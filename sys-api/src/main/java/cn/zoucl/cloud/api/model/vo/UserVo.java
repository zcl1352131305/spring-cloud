package cn.zoucl.cloud.api.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Data
public class UserVo implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String name;
}

