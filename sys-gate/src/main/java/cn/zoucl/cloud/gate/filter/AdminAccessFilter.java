package cn.zoucl.cloud.gate.filter;

import cn.zoucl.cloud.gate.feign.IAuthService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {

    private final  String ignorePath = "/sysAuth/*";

    @Autowired
    private IAuthService authService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * api网关拦截器进行权限校验
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        final String requestUri = request.getRequestURI().toString();
        final String method = request.getMethod();

        //不进行权限验证的地址
        if(isIgnore(requestUri)){
            return null;
        }

        //权限验证






        log.error(requestUri+"---"+method);

        return null;
    }


    private boolean isIgnore(String path){
        boolean rs = false;
        for(String p:ignorePath.split(",")){
            if(p.indexOf("*") != -1){
                if(path.indexOf(p.replaceAll("\\*","")) != -1){
                    rs = true;
                    break;
                }
            }
            else{
                if(p.equals(path)){
                    rs = true;
                }
            }
        }
        return rs;
    }


}
