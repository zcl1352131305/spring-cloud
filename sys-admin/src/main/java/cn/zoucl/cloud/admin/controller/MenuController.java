package cn.zoucl.cloud.admin.controller;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.admin.model.vo.GroupTree;
import cn.zoucl.cloud.admin.model.vo.ResourceVo;
import cn.zoucl.cloud.admin.service.ElementService;
import cn.zoucl.cloud.admin.service.MenuService;
import cn.zoucl.cloud.common.controller.BaseController;
import cn.zoucl.cloud.common.utils.Result;
import cn.zoucl.cloud.common.utils.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController<MenuService,Menu> {

    @GetMapping("/tree")
    public Result tree(){
        Result rs = null;
        List<FrontMenuVo> menuTrees = baseService.menuTrees();
        if(null != menuTrees && menuTrees.size() > 0){
            rs = Result.success(menuTrees);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }

    @GetMapping("/treeWithAuth")
    public Result treeWithAuth(){
        Result rs = null;
        List<ResourceVo> menuTrees = baseService.menuTreesWithAuth();
        if(null != menuTrees && menuTrees.size() > 0){
            rs = Result.success(menuTrees);
        }
        else{
            rs = Result.fail();
        }
        return rs;
    }
}
