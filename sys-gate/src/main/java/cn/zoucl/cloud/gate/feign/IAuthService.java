package cn.zoucl.cloud.gate.feign;

import cn.zoucl.cloud.common.utils.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 权限验证feign，
 */
@FeignClient(name = "sys-auth")
public interface IAuthService {
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password);

}
