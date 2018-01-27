package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
@Table(name = "t_base_user")
public class User extends BaseEntity {

    private String username;

    private String password;

    private String name;

    private String gender;

    private Date birthday;

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


}
