package cn.zoucl.cloud.admin.model.vo;

import cn.zoucl.cloud.common.model.entity.TreeNode;
import lombok.Data;

import javax.persistence.Table;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
public class FrontMenuVo extends TreeNode {

    private String code;

    private String name;

    private String path;

    private String href;

    private String icon;

    private Integer sort;



}
