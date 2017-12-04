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
    public Result<PermissionVo> getUserPermissions(@PathVariable("userId") String userId){
        Result<PermissionVo> rs = null;
        if(Validator.isEmpty(userId)){
            rs = Result.fail("用户ID不能为空！");
        }
        else{
            rs = Result.success(baseService.selectPermissionsByUserId(userId));
        }
        return rs;

    }

}
