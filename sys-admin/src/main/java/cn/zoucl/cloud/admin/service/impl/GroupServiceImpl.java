package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.GroupMapper;
import cn.zoucl.cloud.admin.mapper.GroupUserMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Group;
import cn.zoucl.cloud.admin.model.entity.GroupUser;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.model.vo.GroupTree;
import cn.zoucl.cloud.admin.service.GroupService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import cn.zoucl.cloud.common.utils.IdUtil;
import cn.zoucl.cloud.common.utils.Validator;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
