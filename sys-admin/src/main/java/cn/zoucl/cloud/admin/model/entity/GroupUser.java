package cn.zoucl.cloud.admin.model.entity;

import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Data
public class GroupUser {

    private String id;

    private String groupId;

    private String userId;

    private String userName;

    private String userGender;

    private String userBirthday;

    private String userPhone;



}
