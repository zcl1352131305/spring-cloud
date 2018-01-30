package cn.zoucl.cloud.admin.model.vo;

import cn.zoucl.cloud.common.model.entity.TreeNode;
import lombok.Data;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Data
public class GroupTree extends TreeNode {
    private String code;

    private String name;

    private String path;

    private String type;
}
