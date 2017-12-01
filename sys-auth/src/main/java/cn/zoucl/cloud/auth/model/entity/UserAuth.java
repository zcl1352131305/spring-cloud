package cn.zoucl.cloud.auth.model.entity;

import lombok.Data;

/**
 * 用户验证实体
 */
@Data
public class UserAuth {
    private String username;
    private String password;
}
