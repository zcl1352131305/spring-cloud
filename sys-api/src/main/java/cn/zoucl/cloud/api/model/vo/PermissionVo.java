package cn.zoucl.cloud.api.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Data
public class PermissionVo implements Serializable {

    private String menuId;

    private String code;

    private String name;

    private String uri;

    private String method;

}
