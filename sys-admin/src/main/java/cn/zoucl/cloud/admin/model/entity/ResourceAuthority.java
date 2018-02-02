package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
@Table(name = "t_base_resource_authority")
public class ResourceAuthority extends BaseEntity {

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "resource_id")
    private String resourceId;

    @Column(name = "is_show")
    private String isShow;


    private String type;


}
