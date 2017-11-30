package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Data
@Table(name = "t_base_group")
public class Group extends BaseEntity {

    private String code;

    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    private String path;

    private String type;

}
