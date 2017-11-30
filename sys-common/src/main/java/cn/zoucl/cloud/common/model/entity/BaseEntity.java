package cn.zoucl.cloud.common.model.entity;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public class BaseEntity {
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
