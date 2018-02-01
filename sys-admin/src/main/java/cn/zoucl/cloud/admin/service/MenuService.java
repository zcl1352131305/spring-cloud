package cn.zoucl.cloud.admin.service;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.admin.model.vo.FrontMenuVo;
import cn.zoucl.cloud.api.model.vo.PermissionVo;
import cn.zoucl.cloud.common.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 查询树形结构菜单
     * @return
     */
    public List<FrontMenuVo> menuTrees();
}
