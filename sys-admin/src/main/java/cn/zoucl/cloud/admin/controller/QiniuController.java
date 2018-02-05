package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.User;
import cn.zoucl.cloud.admin.model.vo.FrontUserVo;
import cn.zoucl.cloud.admin.service.UserService;
import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.controller.BaseController;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.ResultCode;
import cn.zoucl.cloud.common.utils.Validator;
import com.qiniu.util.Auth;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/qiniu")
public class QiniuController {



    /**
     * 获取登录用户信息
     * @return
     */
    @GetMapping("/token")
    public Result token(@RequestParam String fileName){
        Result rs = null;
        String accessKey = "6Lke3aMkl3-g5X1gYUltXVDN9yssUpQ43QHmFqZN";
        String secretKey = "PLl0XB-VxENrr7JtLdNCRMgVaXFD36DUODKZIBM6";
        String bucket = "develop";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken;
        if(Validator.notEmpty(fileName)){
            upToken = auth.uploadToken(bucket,fileName);
        }
        else{
            upToken = auth.uploadToken(bucket);
        }

        rs = Result.success("成功",upToken);
        return rs;
    }

}
