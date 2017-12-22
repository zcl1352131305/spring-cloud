package cn.zoucl.cloud.common.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace on 2017/6/12.
 */
public class TreeNodeVo {
    protected int id;
    protected int parentId;

    public List<TreeNodeVo> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeVo> children) {
        this.children = children;
    }

    List<TreeNodeVo> children = new ArrayList<TreeNodeVo>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void add(TreeNodeVo node){
        children.add(node);
    }
}
