package cn.zoucl.cloud.gate.filter;

import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.utils.*;
import cn.zoucl.cloud.gate.feign.IAdminFeign;
import cn.zoucl.cloud.gate.service.RedisService;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {

    private final String tokenHeader = "Token";

    @Autowired
    private IAdminFeign adminFeign;

    @Autowired
    private RedisService redisService;

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

        //解决跨域
        HttpServletResponse response = ctx.getResponse();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("X-Powered-By","Jetty");


        final String requestUri = request.getRequestURI().toString();
        final String method = request.getMethod();

        /**
         * 获取不进行鉴权以及默认的权限
         */
        Map<String,List<PermissionVo>> ignoreAndDefaultPermissions = (Map<String, List<PermissionVo>>) adminFeign.getIgnoreAndDefaultPermissions().getResult();
        List<PermissionVo> ignorePermission = ignoreAndDefaultPermissions.get("ignore");
        List<PermissionVo> defaultPermission = ignoreAndDefaultPermissions.get("default");


        //不进行权限验证的地址
        if(containPermission(ignorePermission,requestUri,method)){return null;}

        //权限验证--------------------------------------
        // 验证方法为首先验证token，如果验证成功，则查询redis，如果没有则根据返回的用户id查询用户权限，并保存到redis中
        UserVo user = getUserInToken(request,ctx);
        if(null == user){return null;}

        //判断是否是默认拥有的权限
        if(containPermission(defaultPermission,requestUri,method)){
            ctx.addZuulRequestHeader("authUserId",user.getId());
            ctx.getRequest().setAttribute("authUser",user);
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.setResponseStatusCode(200);
            return null;
        }
        //获取用户信息后，查询redis有无该用户的所有权限，如果没有，则调用接口获取
       /* List<PermissionVo> userPermissions = (List<PermissionVo>) redisService.get(CommonConstant.REDIS_USER_PERMISSION + user.getId());
        if(null == userPermissions || userPermissions.size() <= 0){*/
        List<PermissionVo> userPermissions = (List<PermissionVo>) adminFeign.userPermissions(user.getId()).getResult();
            /*redisService.set(CommonConstant.REDIS_USER_PERMISSION + user.getId(),userPermissions);
        }*/
        //权限验证
        if (!containPermission(userPermissions,requestUri,method)){
            //无权限
            sendFailResult(ctx,403,new Result(ResultCode.AUTH_ERROR));
            return null;
        }
        ctx.addZuulRequestHeader("authUserId",user.getId());
        ctx.getRequest().setAttribute("authUser",user);
        ctx.setSendZuulResponse(true);// 对该请求进行路由
        ctx.setResponseStatusCode(200);

        return null;
    }


    /**
     * 解析token获取用户
     * @param request
     * @param ctx
     * @return
     */
    private UserVo getUserInToken(HttpServletRequest request, RequestContext ctx){
        UserVo user = null;
        String token = request.getHeader(tokenHeader);
        if(Validator.isEmpty(token)){
            token = request.getParameter(tokenHeader);
        }
        if(Validator.isEmpty(token)){
            //token为空
            sendFailResult(ctx,401,new Result(ResultCode.TOKEN_NULL));
            return null;
        }
        try {
            user = JWTHelper.getInfoFromToken(token);
            if(null == user){
                //token不可用
                sendFailResult(ctx,402,new Result(ResultCode.TOKEN_ERROR));
                return null;
            }
            //将用户id，用户名，ip地址设置进request
            setCurrentUserInfo(ctx,user);
        } catch (Exception e) {
            e.printStackTrace();
            //token不可用
            sendFailResult(ctx,402,new Result(ResultCode.TOKEN_ERROR));
            return null;
        }
        return user;
    }

    /**
     * 是否包含权限
     * @param permissions
     * @param uri
     * @param method
     * @return
     */
    private boolean containPermission(List<PermissionVo> permissions, String uri, String method){
        boolean containPermit = false;
        for(PermissionVo permission:permissions){
            //表明有权限
            if(uri.indexOf(permission.getUri()) != -1 && method.equals(permission.getMethod())){
                containPermit = true;
                break;
            }
        }
        return containPermit;
    }

    /**
     * 返回错误信息
     * @param ctx
     * @param code
     * @param result
     */
    private void sendFailResult(RequestContext ctx,int code, Result result){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(code);
        ctx.setResponseBody(JSONObject.toJSONString(result));
    }


    /**
     * 设置基础用户信息
     * @param ctx
     * @param user
     */
    private void setCurrentUserInfo(RequestContext ctx, UserVo user) {
        ctx.addZuulRequestHeader("userId", user.getId());
        ctx.addZuulRequestHeader("username", URLEncoder.encode(user.getUsername()));
        ctx.addZuulRequestHeader("userHost", ClientUtil.getClientIp(ctx.getRequest()));
    }

}
