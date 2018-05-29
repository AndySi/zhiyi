package com.idou.modules.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.http.weixin.XmlResult;
import com.foxinmy.weixin4j.jssdk.JSSDKAPI;
import com.foxinmy.weixin4j.jssdk.JSSDKConfigurator;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;
import com.foxinmy.weixin4j.payment.mch.MchPayRequest;
import com.foxinmy.weixin4j.payment.mch.Order;
import com.foxinmy.weixin4j.token.TokenManager;
import com.foxinmy.weixin4j.util.Consts;
import com.foxinmy.weixin4j.util.IOUtil;
import com.foxinmy.weixin4j.util.StringUtil;
import com.foxinmy.weixin4j.xml.ListsuffixResultDeserializer;
import com.foxinmy.weixin4j.xml.XmlStream;
import com.idou.common.enums.TodayRobStatuEnum;
import com.idou.common.exception.RRException;
import com.idou.common.utils.IPUtils;
import com.idou.common.utils.R;
import com.idou.modules.api.dto.ActivityExecutionVo;
import com.idou.modules.api.dto.ApiOrderVo;
import com.idou.modules.api.dto.SaltEntity;
import com.idou.modules.api.service.OrderService;
import com.idou.modules.api.utils.EncryptUtils;
import com.idou.modules.api.utils.ParamsValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.List;

/**
 * 订单
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-28 下午 5:04
 **/
@RestController
@RequestMapping("/api/order")
@Api("订单接口")
public class ApiOrderController extends ApiCommController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;
    @Autowired
    private SaltEntity saltEntity;
    @Autowired
    private WeixinPayProxy weixinPayProxy;

    /**
     * 新增订单
     *
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增订单", notes = "下订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId", value = "商品ID", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "orderNum", value = "订单数量", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "orderMoney", value = "订单总金额", required = true, paramType = "query", dataType = "BigDecimal"),
            @ApiImplicitParam(name = "addressId", value = "收货地址ID", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "receiver", value = "收货人", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tel", value = "收货人电话号码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "md5", value = "md5加密值", required = true, paramType = "query", dataType = "String")
    })
    public R addTodayRobOrder(@RequestParam("itemId") Long itemId,
                              @RequestParam("orderNum") int orderNum,
                              @RequestParam("orderMoney") BigDecimal orderMoney,
                              @RequestParam("addressId") Long addressId,
                              @RequestParam("receiver") String receiver,
                              @RequestParam("tel") String tel,
                              @RequestParam("md5") String md5,
                              HttpServletRequest request) {
        if (md5 == null || !md5.equals(EncryptUtils.EncoderByMd5(saltEntity.getFigure() + itemId))) {
            throw new RRException(TodayRobStatuEnum.DATA_REWRITE.getStateInfo());
        }
        ActivityExecutionVo vo = orderService.saveTodayRobOrderProduce(itemId, orderNum, orderMoney, addressId, receiver, tel, getUserId(request));
        return R.ok().put("data", vo);
    }

    /**
     * 用户查看订单详情
     *
     * @return
     */
    @PostMapping("/queryDetail")
    @ApiOperation(value = "查询订单详情", notes = "用户查看订单详情")
    @ApiImplicitParam(name = "orderNo", value = "订单号", paramType = "query", dataType = "String", required = true)
    public R queryDetail(HttpServletRequest request, @RequestParam("orderNo") String orderNo) {
        ApiOrderVo apiOrderVo = orderService.queryDetail(getUserId(request), orderNo);
        return R.ok().put("data", apiOrderVo);
    }

    /**
     * 用户查看订单列表
     *
     * @param request
     * @return
     */
    @PostMapping("/queryList")
    @ApiOperation(value = "查询订单列表", notes = "用户查看自己的订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", dataType = "String", paramType = "query")
    })
    public R queryList(HttpServletRequest request, @RequestParam("page") String page, @RequestParam("limit") String limit) {
        if (page != null && limit != null) {
            List<ApiOrderVo> list = orderService.queryListByUserId(getUserId(request), ParamsValid.validInt(page), ParamsValid.validInt(limit));
            return R.ok().put("data", list);
        }
        return R.error("参数错误");
    }

    /**
     * 获取签名算法
     *
     * @param url
     * @param orderNo
     * @return
     * @throws WeixinException
     */
    @PostMapping("/getJsSign")
    @ApiOperation(value = "获取签名算法", notes = "获取签名算法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "当前页面地址URL", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "orderNo", value = "订单号", required = true, paramType = "query", dataType = "String")
    })
    public R getJsSign(HttpServletRequest request, @RequestParam("url") String url, @RequestParam("orderNo") String orderNo) throws WeixinException {
        if (orderService.queryOverdue(getUserId(request), orderNo)) {
            WeixinProxy weixinProxy = new WeixinProxy();
            TokenManager tokenManager = weixinProxy.getTokenManager();
            JSSDKConfigurator jssdk = new JSSDKConfigurator(tokenManager);
            jssdk.apis(JSSDKAPI.chooseWXPay);
            JSONObject ret = new JSONObject();
            try {
                String jsonData = jssdk.toJSONConfig(url);
                ret.put("jsonData", jsonData);
            } catch (WeixinException e) {
                logger.error(e.getMessage());
            }
            return R.ok().put("data", ret);
        }
        return null;
    }

    @ApiIgnore
    @RequestMapping("/getPrepay")
    @ResponseBody
    public JSONObject getPrepay(HttpServletRequest request, @RequestParam("param") String param) throws UnsupportedEncodingException {
        JSONObject ret = new JSONObject();
        JSONObject jsonObject = JSONObject.parseObject(param);
        // 用户的唯一标识
        String openId = "ohyvrvo2Eq-Hn5mH5ANxd-f9ySd8";
        // 支付描述
        String body = URLDecoder.decode(jsonObject.getString("body"), "UTF-8");
        // 商户唯一订单号
        String outTradeNo = jsonObject.getString("outTradeNo");
        // 订单金额
        double totalFee = jsonObject.getDouble("totalFee");
        // 支付完成后的回调地址
        String notifyUrl = jsonObject.getString("notifyUrl");
        // 发起支付时的客户端IP地址
        String createIp = IPUtils.getIpAddr(request);
        // 支付时的附加信息,在回调时会原样带上,可为空
        String attach = "";
        // 发起一个JS支付请求,这里有个值得注意的地方：微信返回的预交易ID(payRequest.getPrePayId())是有2小时的时效性的，
        // 超过2小时将不能重新发起支付，需重新生成一个`outTradeNo`订单号再次调用createJSPayRequest接口。
        // 所以这里的`prePayId`有两种解决方案：1、每次发起支付都重新生成`outTradeNo`订单号，然后调用createJSPayRequest接口。
        // 2、把`prePayId`缓存起来，然后通过：MchPayRequest payRequest = new JSAPIPayRequest(prePayId,weixinPayProxy.getPayAccount());
        // 构建一个`MchPayRequest`支付对象。两种方式都有利有弊，请根据实际需求而定。
        MchPayRequest payRequest = null;
        try {
            payRequest = weixinPayProxy.createJSPayRequest(openId, body, outTradeNo, totalFee, notifyUrl, createIp, attach);
        } catch (WeixinException e) {
            logger.error(e.getMessage());
        }
        // 将支付JSON串放到request作用域
        ret.put("jsPay", payRequest.toRequestString());
        return ret;
    }

    /**
     * 微信支付成功(前端)时的回调通知
     *
     * @param input
     */
    @ApiIgnore
    @RequestMapping("/notify")
    @ResponseBody
    public String payNotify(InputStream input) throws IOException {
        String content = StringUtil.newStringUtf8(IOUtil.toByteArray(input));
        Order order = ListsuffixResultDeserializer.deserialize(content,
                Order.class);
        logger.info("jsapi_notify_order_info:", order);
        //验证签名
        String sign = order.getSign();
        String valid_sign = weixinPayProxy.getWeixinSignature().sign(order);
        logger.info("微信签名----->sign={},vaild_sign={}", sign, valid_sign);
        if (!sign.equals(valid_sign)) {
            return XmlStream.toXML(new XmlResult(Consts.FAIL, "签名错误"));
        }
        // TODO 处理业务逻辑，如没有特殊要求可以考虑单独启一个线程去处理自己的业务，对于微信签名过后就可以返回success了。
        // 需要ajax的形式返回给微信，保证返回值能写到ResponseInputStream就行
        return XmlStream.toXML(new XmlResult(Consts.SUCCESS, ""));
    }
}
