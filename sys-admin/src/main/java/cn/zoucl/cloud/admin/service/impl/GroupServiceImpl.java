package cn.zoucl.cloud.admin.service.impl;

import cn.zoucl.cloud.admin.mapper.GroupMapper;
import cn.zoucl.cloud.admin.mapper.UserMapper;
import cn.zoucl.cloud.admin.model.entity.Group;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.GroupService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<GroupMapper,Group> implements GroupService {
}
