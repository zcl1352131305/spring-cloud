package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.MenuMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import cn.zoucl.cloud.common.utils.IdUtil;
import com.netflix.discovery.converters.Auto;
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
public class ElementServiceImpl extends BaseServiceImpl<ElementMapper,Element> implements ElementService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询用户拥有权限
     * @param userId
     * @return
     */
    @Override
    public List<PermissionVo> selectPermissionsByUserId(String userId) {
        List<Element> elements = mapper.selectUserPermissions(userId);
        List<PermissionVo> permissionVos = new ArrayList<>();
        for(Element e:elements){
            PermissionVo vo = new PermissionVo();
            BeanUtils.copyProperties(e,vo);
            permissionVos.add(vo);
        }

        return permissionVos;
    }

    @Override
    public Map<String, List<PermissionVo>> selectIgnoreAndDefaultPermissions() {
        Element element = new Element();
        element.setMenuId("-1");
        List<Element> elements = selectList(element);
        List<PermissionVo> ignorePermissions = new ArrayList<>();
        for (Element e:elements) {
            PermissionVo vo = new PermissionVo();
            BeanUtils.copyProperties(e,vo);
            ignorePermissions.add(vo);
        }
        element.setMenuId("0");
        elements = selectList(element);
        List<PermissionVo> defaultPermissions = new ArrayList<>();
        for (Element e:elements) {
            PermissionVo vo = new PermissionVo();
            BeanUtils.copyProperties(e,vo);
            defaultPermissions.add(vo);
        }

        Map<String,List<PermissionVo>> resultMap = new HashMap<>();
        resultMap.put("ignore",ignorePermissions);
        resultMap.put("default",defaultPermissions);

        return resultMap;
    }


    public void initElement(String menuId){
        Menu menu = menuMapper.selectByPrimaryKey(menuId);

        //查询
        Element getE = new Element();
        getE.setId(IdUtil.createUUID(32));
        getE.setCode(menu.getCode() + ":view");
        getE.setMenuId(menuId);
        getE.setMethod("GET");
        getE.setName("查询");
        getE.setUri(menu.getPath());

        //新增
        Element postE = new Element();
        postE.setId(IdUtil.createUUID(32));
        postE.setCode(menu.getCode() + ":btn_add");
        postE.setMenuId(menuId);
        postE.setMethod("POST");
        postE.setName("新增");
        postE.setUri(menu.getPath());

        //修改
        Element putE = new Element();
        putE.setId(IdUtil.createUUID(32));
        putE.setCode(menu.getCode() + ":btn_upd");
        putE.setMenuId(menuId);
        putE.setMethod("PUT");
        putE.setName("修改");
        putE.setUri(menu.getPath());

        //删除
        Element deleteE = new Element();
        deleteE.setId(IdUtil.createUUID(32));
        deleteE.setCode(menu.getCode() + ":btn_del");
        deleteE.setMenuId(menuId);
        deleteE.setMethod("DELETE");
        deleteE.setName("删除");
        deleteE.setUri(menu.getPath());

        mapper.insert(getE);
        mapper.insert(postE);
        mapper.insert(putE);
        mapper.insert(deleteE);

    }
}
