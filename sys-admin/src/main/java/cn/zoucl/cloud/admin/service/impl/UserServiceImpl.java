package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.MenuMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.model.vo.FrontUserVo;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ElementMapper elementMapper;

    @Override
    public User selectByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }

    @Override
    public FrontUserVo getLoginUserDetail(String userId){
        User user = selectById(userId);
        FrontUserVo userVo = null;
        if(null != user){
            userVo = new FrontUserVo();
            BeanUtils.copyProperties(user,userVo);
            List<Menu> menus = menuMapper.selectUserMenu(userId);
            List<FrontMenuVo> menuVos = new ArrayList<>();
            for(Menu menu:menus){
                FrontMenuVo vo = new FrontMenuVo();
                BeanUtils.copyProperties(menu,vo);
                menuVos.add(vo);
            }
            userVo.setMenus(toTree(menuVos));
            /*List<Element> elements = elementMapper.selectUserPermissions(userId);
            userVo.setElements(elements);*/
        }
        return userVo;
    }


    private List<FrontMenuVo> toTree(List<FrontMenuVo> menus){
        List<FrontMenuVo> topMenus = new ArrayList<>();

        for (FrontMenuVo menu:menus){
            if(menu.getParentId().equals("-1")){
                topMenus.add(menu);
            }
        }
        for(FrontMenuVo menu:topMenus){
            menu.setChildren(getChildren(menu,menus));
        }

        return topMenus;
    }

    private List<TreeNode> getChildren(FrontMenuVo menu, List<FrontMenuVo> menus){
        List<TreeNode> menus1 = new ArrayList<>();
        for (FrontMenuVo menu1:menus){
            if(menu1.getParentId().equals(menu.getId())){
                menu1.setChildren(getChildren(menu1,menus));
                menus1.add(menu1);
            }
        }
        return menus1;
    }




}
