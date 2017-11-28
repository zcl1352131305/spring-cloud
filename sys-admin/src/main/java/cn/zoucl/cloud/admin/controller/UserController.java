package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/sysAdmin")
public class UserController {
    @GetMapping("/user")
    public User findById() {
        User u = new User();
        u.setId("1231");
        u.setUsername("zoucl");
        u.setPassword("1234566");
        return u;
    }
}
