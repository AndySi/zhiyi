<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>

<html>
<head>
    <title>微信H5支付Demo</title>
    <script>
        var ctx = '${ctx}';
    </script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/md5.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/define/common.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
<input type="button" value="支付" onclick="fn_pay()">
</body>
<script>
    $(function () {
        var config = {
            debug: '',    // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: '',    // 必填，公众号的唯一标识
            timestamp: '',    // 必填，生成签名的时间戳
            nonceStr: '',  // 必填，生成签名的随机串
            signature: '',    // 必填，签名，见附录1
            jsApiList: [
                'checkJsApi',
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo'
            ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        };
        /**
         * 注入权限验证配置
         */
        $.post(ctx + '/wechat/getJsSign', {url: window.location.href}, function (resp) {
            var result = JSON.parse(resp.jsonData);
            config.debug = result.debug;
            config.appId = result.appId;
            config.timestamp = result.timestamp;
            config.nonceStr = result.nonceStr;
            config.signature = result.signature;
        });
        wx.config(config);

        wx.error(function (res) {
            console.log("error:" + res);
        })
    });

    /**
     * 支付操作
     */
    function fn_pay() {
        //封装参数
        var param = {};
        //商品描述
        param.body = encodeURI("思哥充值中心-QQ会员充值");
        //商户订单号
        param.outTradeNo = "ZS201702171157" + Math.floor(Math.random() * 10);
        //订单总金额
        param.totalFee = 1;
        //支付完成后的回调地址
        param.notifyUrl = "http://" + window.location.host + "/" + ctx + "/wechat/notify";
        $.post(ctx + '/wechat/getPrepay', {param: JSON.stringify(param)}, function (resp) {
            if (resp.statu == "SUCCESS") {
                // 预支付ID
                var jsPay = resp.jsPay;
                if (typeof WeixinJSBridge == "undefined") {
                    if (document.addEventListener) {
                        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                    } else if (document.attachEvent) {
                        document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                    }
                } else {
                    onBridgeReady(jsPay);
                }
            }
        })
    }

    /**
     * 调起支付API
     * @param appId
     * @param timeStamp
     * @param nonceStr
     * @param package
     * @param paysign
     */
    function onBridgeReady(jspay) {
        WeixinJSBridge.invoke('getBrandWCPayRequest', jspay,
            function (res) {
                // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                if (res.err_msg == "get_brand_wcpay_request：ok") {
                    //支付成功
                    alert("支付成功，哈哈！");
                } else if (res.err_msg == "get_brand_wcpay_request:fail") {
                    //支付失败
                    alert("支付失败，FUCK！");
                } else if (res.err_msg == "get_brand_wcpay_request：cancel") {
                    alert("取消哒，不要哒");
                }
            }
        );
    }
</script>
</html>
