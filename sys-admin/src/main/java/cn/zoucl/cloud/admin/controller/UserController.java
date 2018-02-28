package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.model.vo.FrontUserVo;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.controller.BaseController;
import cn.zoucl.cloud.common.utils.JWTHelper;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.ResultCode;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserService,User> {


    /**
     * 用户名密码校验------
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/validate")
    public Result validate(String username, String password){
        Result rs = null;
        if(Validator.isEmpty(username)){
            rs = Result.fail("用户名不能为空！");
        }
        else if(Validator.isEmpty(password)){
            rs = Result.fail("密码不能为空！");
        }
        else{
            User user = baseService.selectByUsername(username);
            if(null != user){
                if(user.getPassword().equals(password)){
                    UserVo userVo = new UserVo();
                    BeanUtils.copyProperties(user,userVo);
                    rs = new Result(ResultCode.SUCCESS,"成功！",userVo);
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

    /**
     * 获取登录用户信息
     * @return
     */
    @GetMapping("/loginUserInfo")
    public Result loginUserInfo(){
        Result rs = null;
        String userId = request.getHeader("authUserId");
        if(Validator.isEmpty(userId)){
            rs = Result.fail();
        }
        else{
            FrontUserVo userVo = baseService.getLoginUserDetail(userId);
            if(null != userVo){
                rs = Result.success(userVo);
            }
            else{
                rs = Result.fail();
            }

        }

        return rs;
    }

}
