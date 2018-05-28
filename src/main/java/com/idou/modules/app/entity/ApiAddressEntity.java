package com.idou.modules.app.entity;

import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 地址接口
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 3:46
 **/
public class ApiAddressEntity implements Serializable {
    private static final long serialVersionUID = 8021418659438279901L;

    @NotNull(message = "地址ID不能为空", groups = UpdateGroup.class)
    private Long id;
    @ApiModelProperty(value = "收货人电话[新增必填]", required = true)
    @NotBlank(message = "收货人电话不能为空", groups = AddGroup.class)
    private String tel;
    @ApiModelProperty(value = "收货人姓名[新增必填]", required = true)
    @NotBlank(message = "收货人姓名不能为空", groups = AddGroup.class)
    private String uName;
    @ApiModelProperty(hidden = true)
    private Long userId;
    @ApiModelProperty(value = "收货详细地址[新增必填]", required = true)
    @NotBlank(message = "收货详细地址不能为空", groups = AddGroup.class)
    private String address;
    @ApiModelProperty(value = "是否默认收货地址[新增必填]", required = true)
    @NotNull(message = "是否默认不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Integer isDefault;
    @ApiModelProperty(hidden = true)
    private Date createTime;

    private String utel;
    private String nickName;

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
