package cn.zoucl.cloud.admin.model.vo;

import cn.zoucl.cloud.admin.model.entity.Element;
import cn.zoucl.cloud.admin.model.entity.Menu;
import cn.zoucl.cloud.common.model.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@Data
public class FrontUserVo {

    private String id;

    private String username;

    private String name;

    private String headImg;

    private List<FrontMenuVo> menus;

    private String elements;


}
