package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.User;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.common.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/sysAdmin/user")
public class UserController extends BaseController<UserService,User> {

}
