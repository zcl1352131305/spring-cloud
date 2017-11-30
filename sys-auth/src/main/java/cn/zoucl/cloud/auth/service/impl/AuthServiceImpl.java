package cn.zoucl.cloud.auth.service.impl;

import cn.zoucl.cloud.auth.feign.IAdminService;
import cn.zoucl.cloud.auth.service.AuthService;
import cn.zoucl.cloud.common.utils.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private IAdminService adminService;


    public Result login(String username, String password){
        Result obj = adminService.validate(username,password);
        Result rs = null;
        if(obj.getCode().equals("200")){
            JSONObject json = JSON.parseObject(JSON.toJSONString(rs.getResult()));

        }
        else{

        }

        return null;

    }

}
