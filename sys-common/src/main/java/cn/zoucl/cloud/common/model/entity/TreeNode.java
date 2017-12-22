package cn.zoucl.cloud.common.model.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace on 2017/6/12.
 */
@Data
public class TreeNode {

    private String id;

    private String parentId;

    List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node){
        children.add(node);
    }
}
