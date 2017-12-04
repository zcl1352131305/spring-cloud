package cn.zoucl.cloud.admin.mapper;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface ElementMapper extends Mapper<Element> {
    List<Element> selectUserPermissions(String userId);
}
