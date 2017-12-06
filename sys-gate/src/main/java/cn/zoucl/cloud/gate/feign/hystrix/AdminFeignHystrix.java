package cn.zoucl.cloud.gate.feign.hystrix;

import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.gate.feign.IAdminFeign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/30 0030.
 * 断路器，当请求sys-admin超时时执行
 */
@Component
public class AdminFeignHystrix implements IAdminFeign {


    @Override
    public Result<List<PermissionVo>> userPermissions(String userId) {
        return Result.fail("连接服务失败！");
    }

    @Override
    public Result<Map<String, List<PermissionVo>>> getIgnoreAndDefaultPermissions() {
        return Result.fail("连接服务失败！");
    }
}
