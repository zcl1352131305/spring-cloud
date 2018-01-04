package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
@Table(name = "t_base_element")
public class Element extends BaseEntity {

    @Column(name = "menu_id")
    private String menuId;



    private String code;

    private String name;

    private String uri;

    private String method;




}
