package cn.zoucl.cloud.gate.feign.hystrix;

import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.gate.feign.IAuthService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Component
public class AuthServiceHystrix implements IAuthService {
    @Override
    public Result login(String username, String password) {
        return Result.fail("服务链接失败！");
    }
}
