package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.*;
import cn.zoucl.cloud.admin.model.entity.*;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.model.vo.GroupTree;
import cn.zoucl.cloud.admin.service.GroupService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import cn.zoucl.cloud.common.utils.IdUtil;
import cn.zoucl.cloud.common.utils.Validator;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<GroupMapper,Group> implements GroupService {

    @Autowired
    private GroupUserMapper groupUserMapper;
    @Autowired
    private ResourceAuthorityMapper resourceAuthorityMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ElementMapper elementMapper;


    public List<GroupUser> groupLeader(Map<String, Object> user){
        return groupUserMapper.selectGroupLeader(user);
    }

    public List<GroupUser> groupMember(Map<String, Object> user){
        return groupUserMapper.selectGroupMember(user);
    }

    public void deleteLeader(String id){
        groupUserMapper.deleteGroupLeader(id);
    }

    public void deleteMember(String id){
        groupUserMapper.deleteGroupMember(id);
    }

    public void addLeader(GroupUser user){
        if(Validator.isEmpty(user.getId())){
            user.setId(IdUtil.createUUID(32));
        }
        groupUserMapper.addGroupLeader(user);
    }

    public void addMember(GroupUser user){
        if(Validator.isEmpty(user.getId())){
            user.setId(IdUtil.createUUID(32));
        }
        groupUserMapper.addGroupMember(user);
    }

    @Override
    public List<GroupTree> groupTrees(){
        List<Group> groups = mapper.selectAll();
        List<GroupTree> groupTrees = new ArrayList<>();
        for(Group group: groups){
            GroupTree groupTree = new GroupTree();
            BeanUtils.copyProperties(group,groupTree);
            groupTrees.add(groupTree);
        }
        return toTree(groupTrees);
    }



    private List<GroupTree> toTree(List<GroupTree> groupTrees){
        List<GroupTree> topMenus = new ArrayList<>();

        for (GroupTree menu:groupTrees){
            if(menu.getParentId().equals("-1")){
                topMenus.add(menu);
            }
        }
        for(GroupTree menu:topMenus){
            menu.setChildren(getChildren(menu,groupTrees));
        }

        return topMenus;
    }

    private List<TreeNode> getChildren(TreeNode menu, List<GroupTree> groupTrees){
        List<TreeNode> menus1 = new ArrayList<>();
        for (GroupTree menu1:groupTrees){
            if(menu1.getParentId().equals(menu.getId())){
                menu1.setChildren(getChildren(menu1,groupTrees));
                menus1.add(menu1);
            }
        }
        return menus1;
    }

    public List<ResourceAuthority> getGroupMenusAndAuths(String groupId){
        return resourceAuthorityMapper.selectResourceByGroupId(groupId);
    }

    public void saveGroupMenusAndAuths(String groupId, List<Map<String,Object>> datas){
        resourceAuthorityMapper.deleteResourceByGroupId(groupId);
        List<Menu> leafMenus = new ArrayList<>();
        List<Element> allElements = elementMapper.selectAll();
        List<Element> insertElement = new ArrayList<>();

        //保存所有元素资源并且找到所有的叶子节点菜单
        for(Map<String,Object> resource : datas){
            ResourceAuthority authority = new ResourceAuthority();
            authority.setId(IdUtil.createUUID(32));
            authority.setGroupId(groupId);
            authority.setResourceId((String) resource.get("id"));
            authority.setType((String) resource.get("type"));
            if(authority.getType().equals("resource")){
                for(Element element:allElements){
                    if(authority.getResourceId().equals(element.getId())){
                        insertElement.add(element);
                    }
                }
                resourceAuthorityMapper.insert(authority);
            }
        }
        List<Menu> allMenus = menuMapper.selectAll();
        for(Element element:insertElement){
            for(Menu menu:allMenus){
                if(element.getMenuId().equals(menu.getId())){
                    if(!hasMenus(menu.getId(),leafMenus)){
                        leafMenus.add(menu);
                    }
                    break;
                }
            }
        }

        List<Menu> menus1  = patchMenus(leafMenus,allMenus);
        for(Menu menu:menus1){
            ResourceAuthority authority = new ResourceAuthority();
            authority.setId(IdUtil.createUUID(32));
            authority.setGroupId(groupId);
            authority.setResourceId(menu.getId());
            authority.setType("menu");
            if(null != menu.getName() && menu.getName().equals("isShow")){
                authority.setIsShow("1");
            }
            else{
                authority.setIsShow("0");
            }
            resourceAuthorityMapper.insert(authority);
        }

    }

    /*public void saveGroupMenusAndAuths(String groupId, List<Map<String,Object>> datas){
        resourceAuthorityMapper.deleteResourceByGroupId(groupId);
        List<ResourceAuthority> menus = new ArrayList<>();
        for(Map<String,Object> resource : datas){
            ResourceAuthority authority = new ResourceAuthority();
            authority.setId(IdUtil.createUUID(32));
            authority.setGroupId(groupId);
            authority.setResourceId((String) resource.get("id"));
            authority.setType((String) resource.get("type"));
            if(authority.getType().equals("resource")){
                resourceAuthorityMapper.insert(authority);
            }
            else{
                menus.add(authority);
            }
        }
        List<Menu> allMenus = menuMapper.selectAll();
        List<Menu> menus1 = new ArrayList<>();
        for(ResourceAuthority m: menus){
            for(Menu menu:allMenus){
                if(m.getResourceId().equals(menu.getId())){
                    menus1.add(menu);
                    break;
                }
            }
        }
        menus1 = patchMenus(menus1,allMenus);
        for(Menu menu:menus1){
            ResourceAuthority authority = new ResourceAuthority();
            authority.setId(IdUtil.createUUID(32));
            authority.setGroupId(groupId);
            authority.setResourceId(menu.getId());
            authority.setType("menu");
            if(null != menu.getName() && menu.getName().equals("isShow")){
                authority.setIsShow("1");
            }
            else{
                authority.setIsShow("0");
            }
            resourceAuthorityMapper.insert(authority);
        }

    }*/

    /**
     * 传过来的参数会缺少父级菜单，下面两个方法进行补全菜单
     * @param menus
     * @param allMenus
     * @return
     */
    private List<Menu> patchMenus(List<Menu> menus, List<Menu> allMenus){
        List<Menu> hasNotParentMenus = new ArrayList<>();
        for(Menu menu:menus){
            if(menu.getParentId().equals("-1") || hasMenus(menu.getParentId(),menus)){
                continue;
            }
            else{
                hasNotParentMenus.add(menu);
            }
        }
        for(Menu menu: hasNotParentMenus){
            for(Menu menu1: allMenus){
                if(menu.getParentId().equals(menu1.getId()) && !hasMenus(menu1.getId(),menus)){
                    menu1.setName("isShow");
                    menus.add(menu1);
                }
            }
        }
        if(hasNotParentMenus.size() > 0){
            patchMenus(menus,allMenus);
        }
        return menus;
    }

    private boolean hasMenus(String menuId, List<Menu> menus){
        boolean has = false;
        for(Menu menu: menus){
            if(menu.getId().equals(menuId)){
                has = true;
            }
        }
        return has;
    }

    private boolean hasElements(String elemId, List<Element> elements){
        boolean has = false;
        for(Element element: elements){
            if(element.getId().equals(elemId)){
                has = true;
            }
        }
        return has;
    }


}
