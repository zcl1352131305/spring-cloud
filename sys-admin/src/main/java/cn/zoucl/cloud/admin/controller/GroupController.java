package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.Group;
import cn.zoucl.cloud.admin.model.entity.GroupUser;
import cn.zoucl.cloud.admin.model.entity.ResourceAuthority;
import cn.zoucl.cloud.admin.model.vo.GroupTree;
import cn.zoucl.cloud.admin.service.GroupService;
import cn.zoucl.cloud.common.controller.BaseController;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/group")
public class GroupController extends BaseController<GroupService,Group> {

    @GetMapping("/tree")
    public Result tree(){
        Result rs = null;
        List<GroupTree> groupTrees = baseService.groupTrees();
        if(null != groupTrees && groupTrees.size() > 0){
            rs = Result.success(groupTrees);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }

    @GetMapping("/leader/get")
    public Result leader(@RequestParam Map<String, Object> params){
        Result rs = null;
        List<GroupUser> users = baseService.groupLeader(params);
        if(null != users && users.size() > 0){
            rs = Result.success(users);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }

    @GetMapping("/member/get")
    public Result member(@RequestParam Map<String, Object> params){
        Result rs = null;
        List<GroupUser> users = baseService.groupMember(params);
        if(null != users && users.size() > 0){
            rs = Result.success(users);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }

    @DeleteMapping("/leader/remove/{id}")
    public Result removeLeader(@PathVariable String id){
        baseService.deleteLeader(id);
        return Result.success();

    }

    @DeleteMapping("/member/remove/{id}")
    public Result removeMember(@PathVariable String id){
        baseService.deleteMember(id);
        return Result.success();
    }

    @PostMapping("/leader/add")
    public Result addLeader(@RequestBody GroupUser groupUser){
        baseService.addLeader(groupUser);
        return Result.success();
    }

    @PostMapping("/member/add")
    public Result addMember(@RequestBody GroupUser groupUser){
        baseService.addMember(groupUser);
        return Result.success();
    }

    @GetMapping("/menuAndAuth/{id}")
    public Result menuAndAuth(@PathVariable String id){
        Result rs = null;
        List<ResourceAuthority> authorities = baseService.getGroupMenusAndAuths(id);
        if(null != authorities && authorities.size() > 0){
            List<Map<String,Object>> newList = new ArrayList<>();
            for(ResourceAuthority auth:authorities){
                Map<String,Object> map = new HashMap<>();
                map.put("id",auth.getId());
                map.put("groupId",auth.getGroupId());
                map.put("resourceId",auth.getResourceId());
                newList.add(map);
            }
            rs = Result.success(newList);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }

    @PutMapping("/menuAndAuth/update")
    public Result menuAndAuthAdd(@RequestBody Map<String,Object> params){
        Result rs = null;
        String groupId = (String) params.get("groupId");
        List<Map<String,Object>> trees = (List<Map<String, Object>>) params.get("resource");
        if(Validator.isEmpty(groupId) || trees == null || trees.size() <= 0){
            rs = Result.fail();
        }
        else{
            baseService.saveGroupMenusAndAuths(groupId,trees);
            rs = Result.success();
        }



        return rs;
    }

}
