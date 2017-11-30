package cn.zoucl.cloud.auth.feign;

import cn.zoucl.cloud.auth.feign.hystrix.AdminServiceHystrix;
import cn.zoucl.cloud.common.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@FeignClient(name = "sys-admin", fallback = AdminServiceHystrix.class)
public interface IAdminService {
    @RequestMapping(value = "/permission/validate", method = RequestMethod.POST)
    public Result validate(@RequestParam("username") String username, @RequestParam("password") String password);


}
