package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.User;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService {
}
