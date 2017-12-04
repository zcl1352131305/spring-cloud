package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.ElementMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            vo.setMenuId(e.getMenuId());
            vo.setCode(e.getCode());
            vo.setMethod(e.getMethod());
            vo.setName(e.getName());
            vo.setUri(e.getUri());
            permissionVos.add(vo);
        }

        return permissionVos;
    }
}
