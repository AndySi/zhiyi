package com.idou.modules.app.dto;

import com.idou.common.validator.group.AddGroup;
import com.idou.modules.app.entity.ApiItemEntity;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 3:50
 **/
public class ApiItemVo extends ApiItemEntity {
    // 分类名称
    private String typeName;
    @NotEmpty(message = "产品详情不能为空", groups = AddGroup.class)
    private List<String> detailArr;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<String> getDetailArr() {
        return detailArr;
    }

    public void setDetailArr(List<String> detailArr) {
        this.detailArr = detailArr;
    }
}
