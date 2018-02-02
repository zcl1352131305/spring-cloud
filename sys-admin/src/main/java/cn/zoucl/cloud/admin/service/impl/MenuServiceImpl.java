package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.MenuMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.model.vo.ResourceVo;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.MenuService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper,Menu> implements MenuService {

    @Autowired
    private ElementMapper elementMapper;

    public List<FrontMenuVo> menuTrees(){
        List<Menu> menus = mapper.selectAll();
        List<FrontMenuVo> menuVos = new ArrayList<>();
        for(Menu menu:menus){
            FrontMenuVo vo = new FrontMenuVo();
            BeanUtils.copyProperties(menu,vo);
            menuVos.add(vo);
        }
        return toTree(menuVos);
    }

    public List<ResourceVo> menuTreesWithAuth(){
        List<Menu> menus = mapper.selectAll();
        List<Element> elements = elementMapper.selectAll();
        List<ResourceVo> menuVos = new ArrayList<>();
        for(Menu menu:menus){
            ResourceVo vo = new ResourceVo();
            vo.setId(menu.getId());
            vo.setParentId(menu.getParentId());
            vo.setName(menu.getName());
            vo.setType("menu");
            menuVos.add(vo);
        }
        return toTreeWithAuth(menuVos,elements);
    }




    private List<FrontMenuVo> toTree(List<FrontMenuVo> menus){
        List<FrontMenuVo> topMenus = new ArrayList<>();

        for (FrontMenuVo menu:menus){
            if(Validator.notEmpty(menu.getParentId()) && menu.getParentId().equals("-1")){
                topMenus.add(menu);
            }
        }
        for(FrontMenuVo menu:topMenus){
            menu.setChildren(getChildren(menu,menus));
        }

        return topMenus;
    }

    private List<TreeNode> getChildren(TreeNode menu, List<FrontMenuVo> menus){
        List<TreeNode> menus1 = new ArrayList<>();
        for (FrontMenuVo menu1:menus){
            if(Validator.notEmpty(menu1.getParentId()) && menu1.getParentId().equals(menu.getId())){
                menu1.setChildren(getChildren(menu1,menus));
                menus1.add(menu1);
            }
        }
        return menus1;
    }



    private List<ResourceVo> toTreeWithAuth(List<ResourceVo> menus, List<Element> allElements){
        List<ResourceVo> topMenus = new ArrayList<>();

        for (ResourceVo menu:menus){
            if(Validator.notEmpty(menu.getParentId()) && menu.getParentId().equals("-1")){
                topMenus.add(menu);
            }
        }
        for(ResourceVo menu:topMenus){
            menu.setChildren(getChildrenWithAuth(menu,menus,allElements));
        }

        return topMenus;
    }


    private List<TreeNode> getChildrenWithAuth(TreeNode menu, List<ResourceVo> menus, List<Element> allElements){
        List<TreeNode> menus1 = new ArrayList<>();
        for (ResourceVo menu1:menus){
            if(Validator.notEmpty(menu1.getParentId()) && menu1.getParentId().equals(menu.getId())){
                menu1.setChildren(getChildrenWithAuth(menu1,menus,allElements));
                menu1.setType("menu");
                if(menu1.getChildren().size() <= 0){ //是叶子节点
                    List<TreeNode> auths = new ArrayList<>();
                    for(Element el : allElements){
                        if(el.getMenuId().equals(menu1.getId())){
                            ResourceVo element = new ResourceVo();
                            element.setId(el.getId());
                            element.setParentId(menu1.getId());
                            element.setName(el.getName());
                            element.setType("resource");
                            auths.add(element);
                        }
                    }
                    menu1.setChildren(auths);

                }
                menus1.add(menu1);
            }
        }
        return menus1;
    }

}
