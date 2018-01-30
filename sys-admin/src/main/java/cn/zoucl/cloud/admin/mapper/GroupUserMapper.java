package cn.zoucl.cloud.admin.mapper;

import cn.zoucl.cloud.admin.model.entity.Group;
import cn.zoucl.cloud.admin.model.entity.GroupUser;
import cn.zoucl.cloud.admin.model.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Component
public interface GroupUserMapper {

    /**
     * 获取组领导
     * @param user
     * @return
     */
    List<GroupUser> selectGroupLeader(Map<String, Object> user);

    /**
     * 获取组成员
     * @param user
     * @return
     */
    List<GroupUser> selectGroupMember(Map<String, Object> user);

    /**
     * 删除组领导
     * @param id
     */
    void deleteGroupLeader(String id);

    /**
     * 删除组成员
     * @param id
     */
    void deleteGroupMember(String id);

    /**
     * 添加组领导
     * @param user
     */
    void addGroupLeader(GroupUser user);

    /**
     * 添加组成员
     * @param user
     */
    void addGroupMember(GroupUser user);
}
