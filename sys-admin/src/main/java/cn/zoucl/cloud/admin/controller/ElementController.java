package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.controller.BaseController;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.ResultCode;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/element")
public class ElementController extends BaseController<ElementService,Element> {

    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    @GetMapping("/permissions/{userId}")
    public Result getUserPermissions(@PathVariable("userId") String userId){
        Result rs = null;
        if(Validator.isEmpty(userId)){
            rs = Result.fail("用户ID不能为空！");
        }
        else{
            rs = Result.success(baseService.selectPermissionsByUserId(userId));
        }
        return rs;
    }

    /**
     * 获取不进行鉴权以及登陆后默认权限
     * @return
     */
    @GetMapping("/permissions/IgnoreAndDefault")
    public Result getIgnoreAndDefaultPermission(){
        return Result.success(baseService.selectIgnoreAndDefaultPermissions());
    }


    @PostMapping("/initElement/{menuId}")
    public Result initElement(@PathVariable String  menuId){
        if(Validator.isEmpty(menuId)){
            return Result.fail("菜单ID不能为空！");
        }
        baseService.initElement(menuId);
        return Result.success();
    }


}
