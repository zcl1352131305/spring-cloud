package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
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
public class ElementServiceImpl extends BaseServiceImpl<ElementMapper,Element> implements ElementService {

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
}
