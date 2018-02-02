package cn.zoucl.cloud.admin.service;

import cn.zoucl.cloud.admin.model.entity.Group;
import cn.zoucl.cloud.admin.model.entity.GroupUser;
import cn.zoucl.cloud.admin.model.entity.ResourceAuthority;
import cn.zoucl.cloud.admin.model.vo.GroupTree;
import cn.zoucl.cloud.common.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface GroupService extends BaseService<Group> {

    /**
     * 获取树状组
     * @return
     */
    public List<GroupTree> groupTrees();

    /**
     * 查询组领导
     * @param user
     * @return
     */
    public List<GroupUser> groupLeader(Map<String, Object> user);

    /**
     * 查询组成员
     * @param user
     * @return
     */
    public List<GroupUser> groupMember(Map<String, Object> user);

    /**
     * 删除组领导
     * @param id
     */
    public void deleteLeader(String id);

    /**
     * 删除组成员
     * @param id
     */
    public void deleteMember(String id);

    /**
     * 添加组领导
     * @param user
     */
    public void addLeader(GroupUser user);

    /**
     * 添加组成员
     * @param user
     */
    public void addMember(GroupUser user);

    /**
     * 查询组拥有的权限
     * @param groupId
     * @return
     */
    public List<ResourceAuthority> getGroupMenusAndAuths(String groupId);

    /**
     * 修改保存组权限
     * @param groupId
     * @param datas
     */
    public void saveGroupMenusAndAuths(String groupId, List<Map<String,Object>> datas);
}
