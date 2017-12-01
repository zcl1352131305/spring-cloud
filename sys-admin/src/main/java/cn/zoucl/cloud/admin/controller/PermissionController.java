package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.ResultCode;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private UserService userService;


    @PostMapping("/validate")
    public Result validate(String username, String password){
        Result<UserVo> rs = null;
        if(Validator.isEmpty(username)){
            rs = Result.fail("用户名不能为空！");
        }
        else if(Validator.isEmpty(password)){
            rs = Result.fail("密码不能为空！");
        }
        else{
            User user = userService.selectByUsername(username);
            if(null != user){
                if(user.getPassword().equals(password)){
                    UserVo userVo = new UserVo();
                    BeanUtils.copyProperties(user,userVo);
                    rs = new Result<UserVo>(ResultCode.SUCCESS,"成功！",userVo);
                    rs = Result.success(userVo);
                }
                else{
                    rs = Result.fail("密码错误！");
                }
            }
            else{
                rs = Result.fail("用户不存在！");
            }
        }
        return rs;
    }



}
