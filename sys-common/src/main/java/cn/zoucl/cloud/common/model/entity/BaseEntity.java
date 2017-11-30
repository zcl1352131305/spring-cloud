package cn.zoucl.cloud.common.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Data
public class BaseEntity {

    @Id
    private Integer id;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "create_id")
    private String createId;

    @Column(name = "create_ip")
    private String createIp;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "update_id")
    private String updateId;

    @Column(name = "update_ip")
    private String updateIp;

    private String version;

    @Column(name = "del_flag")
    private String delFlag;
}
