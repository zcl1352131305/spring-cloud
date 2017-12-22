package cn.zoucl.cloud.admin.mapper;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface MenuMapper extends Mapper<Menu> {
    List<Menu> selectUserMenu(String userId);
}
