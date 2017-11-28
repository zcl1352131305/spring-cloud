package cn.zoucl.cloud.common.controller;

import cn.zoucl.cloud.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class BaseController<Bsi extends BaseService, Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Bsi baseService;


}
