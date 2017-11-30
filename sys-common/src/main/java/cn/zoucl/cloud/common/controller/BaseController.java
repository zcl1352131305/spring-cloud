package cn.zoucl.cloud.common.controller;

import cn.zoucl.cloud.common.service.BaseService;
import cn.zoucl.cloud.common.utils.Query;
import cn.zoucl.cloud.common.utils.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class BaseController<Bsi extends BaseService, Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Bsi baseService;

    @PostMapping("/add")
    public Result add(@RequestBody Entity entity){
        int result=baseService.insertSelective(entity);
        if(result==0){
            return Result.sysError("系统错误！");
        }else{
            return Result.success();
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody Entity entity){
        int result=baseService.updateById(entity);
        if(result==0){
            return Result.sysError("系统错误！");
        }else{
            return Result.success();
        }
    }

    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Integer id){
        int result=baseService.deleteById(id);
        if(result==0){
            return Result.sysError("系统错误！");
        }else{
            return Result.success();
        }
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable Integer id){
        return Result.success(baseService.selectById(id));
    }

    @GetMapping("/all")
    public Result all(){
        return Result.success(baseService.selectListAll());
    }

    @GetMapping("/page")
    public Result page(@RequestParam Map<String, Object> params){
        //查询分页数据
        Query query = new Query(params);
        return baseService.selectPageByQuery(query);
    }

    @GetMapping("/list")
    public Result list(@RequestParam Map<String, Object> params){
        //查询列表数据
        return baseService.selectListByQuery(params);
    }


    /**
     * 获取所有请求参数，封装为map对象
     * @return
     */
    public Map<String,Object> getParameterMap(){
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            parameterMap.put(key,value);
        }
        return parameterMap;
    }


}
