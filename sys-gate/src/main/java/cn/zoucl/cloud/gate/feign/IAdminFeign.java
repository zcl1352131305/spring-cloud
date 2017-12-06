package cn.zoucl.cloud.gate.feign;

import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.gate.feign.hystrix.AdminFeignHystrix;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@FeignClient(name = "sys-admin",fallback = AdminFeignHystrix.class)
public interface IAdminFeign {

    /**
     * 获取用户权限
     * @param userId
     * @return
     */
    @RequestMapping(value = "/element/permissions/{userId}", method = RequestMethod.GET)
    public Result<List<PermissionVo>> userPermissions(@PathVariable("userId") String userId);

    @RequestMapping(value = "/element/permissions/IgnoreAndDefault", method = RequestMethod.GET)
    public Result<Map<String,List<PermissionVo>>> getIgnoreAndDefaultPermissions();

}
