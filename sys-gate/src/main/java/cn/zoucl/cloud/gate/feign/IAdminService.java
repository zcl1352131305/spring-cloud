package cn.zoucl.cloud.gate.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@FeignClient(name = "sys-admin")
public interface IAdminService {



}
