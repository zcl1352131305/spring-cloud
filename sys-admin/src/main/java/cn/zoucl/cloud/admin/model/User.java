package cn.zoucl.cloud.admin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
@Table(name = "t_sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    private String password;

    private String name;

    private String gender;

    private String birthday;

    private String phone;

    private String email;

    @Column(name = "head_img")
    private String headImg;

    private String address;

    @Column(name = "reg_date")
    private Date regDate;

    private String enabled;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "credential_code")
    private String credentialCode;

    private String credential;

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
