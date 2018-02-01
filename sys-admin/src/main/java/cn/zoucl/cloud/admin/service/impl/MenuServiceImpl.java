package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.MenuMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.MenuService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.beans.BeanUtils;
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

}
