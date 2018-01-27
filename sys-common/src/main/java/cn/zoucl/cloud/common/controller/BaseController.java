package cn.zoucl.cloud.common.controller;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import cn.zoucl.cloud.common.service.BaseService;
import cn.zoucl.cloud.common.utils.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class BaseController<Bsi extends BaseService, Entity extends BaseEntity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Bsi baseService;

    @PostMapping("/add")
    public Result add(@RequestBody Entity entity){
        String userId = request.getHeader("userId");
        String userHost = request.getHeader("userHost");
        if(Validator.notEmpty(userId) && Validator.notEmpty(userHost)){
            entity.setCreateId(userId);
            entity.setCreateIp(userHost);
            entity.setUpdateId(userId);
            entity.setUpdateIp(userHost);
            entity.setDateCreated(new Date());
            entity.setDateUpdated(new Date());
        }
        if(Validator.isEmpty(entity.getId())){
            entity.setId(IdUtil.createUUID(32));
        }
        int result=baseService.insertSelective(entity);
        if(result==0){
            return Result.fail();
        }else{
            return Result.success();
        }


    }

    @PutMapping("/update")
    public Result update(@RequestBody Entity entity){
        String userId = request.getHeader("userId");
        String userHost = request.getHeader("userHost");
        if(Validator.notEmpty(userId) && Validator.notEmpty(userHost)){
            entity.setUpdateId(userId);
            entity.setUpdateIp(userHost);
            entity.setDateUpdated(new Date());
        }
        int result=baseService.updateSelectiveById(entity);
        if(result==0){
            return Result.fail();
        }else{
            return Result.success();
        }
    }

    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id){
        int result=baseService.deleteById(id);
        if(result==0){
            return Result.fail();
        }else{
            return Result.success();
        }
    }

    @DeleteMapping("/batchRemove/{ids}")
    public Result batchRemove(@PathVariable String ids){
        String [] idList = ids.split(",");
        if(null != idList && idList.length > 0){
            for(String id: idList){
                baseService.deleteById(id);
            }
        }
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id){
        return Result.success(baseService.selectById(id));
    }

    @GetMapping("/all")
    public Result all(){
        String userId = request.getHeader("userId");
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
