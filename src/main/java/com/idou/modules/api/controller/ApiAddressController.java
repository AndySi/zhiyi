package com.idou.modules.api.controller;

import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.api.entity.ApiAddressEntity;
import com.idou.modules.api.entity.ApiUserEntity;
import com.idou.modules.api.interceptor.AuthorizationInterceptor;
import com.idou.modules.api.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 收货地址
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 3:20
 **/
@RestController
@RequestMapping("/api/address")
@Api("收货地址接口")
public class ApiAddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 新增收货地址
     *
     * @param addressEntity
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增收货地址", notes = "如果需要设置成默认收货地址,是否默认字段(isDefault)传0,否则传1,详情参考Model说明,参数有必填提示和说明")
    @ApiImplicitParam(name = "addressEntity", value = "地址实体类", paramType = "body", dataType = "ApiAddressEntity", required = true)
    public R addAddress(@RequestBody ApiAddressEntity addressEntity, HttpServletRequest request) {
        ValidatorUtils.validateEntity(addressEntity, AddGroup.class);
        ApiUserEntity userEntity = (ApiUserEntity) request.getSession().getAttribute(AuthorizationInterceptor.OAUTH_USER_KEY);
        if (userEntity != null) {
            addressEntity.setUserId(userEntity.getId());
            addressService.save(addressEntity);
            return R.ok();
        }
        // TODO 仅用于测试，走微信逻辑，需要删除
        addressEntity.setUserId(1L);
        addressService.save(addressEntity);
        return R.ok();
    }

    /**
     * 删除收货地址
     *
     * @param id
     * @return
     */
    @PostMapping("/del")
    @ApiOperation(value = "删除收货地址", notes = "用户删除收货地址,根据地址ID(id)删除")
    @ApiImplicitParam(name = "id", value = "地址ID", paramType = "query", dataType = "Long", required = true)
    public R delAddress(@RequestParam("id") Long id) {
        Map<String, Object> map = new HashedMap();
        map.put("id", id);
        addressService.delete(map);
        return R.ok();
    }

    /**
     * 修改收货地址
     *
     * @param addressEntity
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改收货地址", notes = "用户修改收货地址")
    @ApiImplicitParam(name = "addressEntity", value = "地址实体类", paramType = "body", dataType = "ApiAddressEntity", required = true)
    public R updateAddress(@RequestBody ApiAddressEntity addressEntity, HttpServletRequest request) {
        ValidatorUtils.validateEntity(addressEntity, UpdateGroup.class);
        ApiUserEntity userEntity = (ApiUserEntity) request.getSession().getAttribute(AuthorizationInterceptor.OAUTH_USER_KEY);
        // TODO 仅用于测试，走微信逻辑，需要删除
        if (userEntity != null) {
            addressEntity.setUserId(userEntity.getId());
        } else {
            addressEntity.setUserId(1L);
        }
        addressService.update(addressEntity);
        return R.ok();
    }

    /**
     * 查询收货地址详情
     *
     * @param id
     * @return
     */
    @PostMapping("/queryDetail")
    @ApiOperation(value = "查询地址详情", notes = "根据地址ID(id)获取收货地址详情")
    @ApiImplicitParam(name = "id", value = "地址ID", paramType = "query", dataType = "Long", required = true)
    public R queryAddressInfo(@RequestParam("id") Long id) {
        return R.ok().put("data", addressService.queryInfoById(id));
    }

    /**
     * 根据用户ID查询收货地址列表
     *
     * @param request
     * @return
     */
    @PostMapping("/queryList")
    @ApiOperation(value = "查询地址列表", notes = "用户查询收货地址列表")
    public R queryAddressList(HttpServletRequest request) {
        ApiUserEntity userEntity = (ApiUserEntity) request.getSession().getAttribute(AuthorizationInterceptor.OAUTH_USER_KEY);
        List<ApiAddressEntity> data = null;
        if (userEntity != null) {
            data = addressService.queryListByUid(userEntity.getId());
            return R.ok().put("data", data);
        }
        // TODO 仅用于测试，走微信逻辑，需要删除
        data = addressService.queryListByUid(1L);
        return R.ok().put("data", data);
    }
}
