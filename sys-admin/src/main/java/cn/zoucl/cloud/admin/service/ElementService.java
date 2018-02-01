package cn.zoucl.cloud.admin.service;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.BaseService;

import java.security.Permission;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface ElementService extends BaseService<Element> {
    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    public List<PermissionVo> selectPermissionsByUserId(String userId);

    /**
     * 查询不进行鉴权以及登陆后默认权限
     * @return
     */
    public Map<String,List<PermissionVo>> selectIgnoreAndDefaultPermissions();

    /**
     * 初始化菜单权限信息
     * @param menuId
     */
    public void initElement(String menuId);
}
