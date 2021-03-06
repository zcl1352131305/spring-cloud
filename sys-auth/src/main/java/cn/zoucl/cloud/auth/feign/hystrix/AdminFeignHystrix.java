package cn.zoucl.cloud.auth.feign.hystrix;

import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.auth.feign.IAdminFeign;
import cn.zoucl.cloud.common.utils.Result;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/30 0030.
 * 断路器，当请求sys-admin超时时执行
 */
@Component
public class AdminFeignHystrix implements IAdminFeign {
    @Override
    public Result validate(String username, String password) {
        return Result.fail("连接服务失败！");
    }

   /* @Override
    public Result<PermissionVo> userPermissions(String userId) {
        return Result.fail("连接服务失败！");
    }*/
}
