package cn.zoucl.cloud.admin.service;

import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.model.vo.FrontUserVo;
import cn.zoucl.cloud.common.service.BaseService;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface UserService extends BaseService<User> {
    public User selectByUsername(String username);

    public FrontUserVo getLoginUserDetail(String userId);
}
