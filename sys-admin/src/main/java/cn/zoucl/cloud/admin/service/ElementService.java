package cn.zoucl.cloud.admin.service;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.BaseService;

import java.security.Permission;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface ElementService extends BaseService<Element> {
    public List<PermissionVo> selectPermissionsByUserId(String userId);
}
