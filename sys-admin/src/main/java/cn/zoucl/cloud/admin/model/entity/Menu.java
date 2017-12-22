package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import cn.zoucl.cloud.common.model.entity.TreeNode;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
@Table(name = "t_base_menu")
public class Menu extends BaseEntity {

    private String code;

    private String name;

    @Column(name = "parent_id")
    private String parentId;

    private String path;

    private String href;

    private String icon;

    private Integer sort;



}
