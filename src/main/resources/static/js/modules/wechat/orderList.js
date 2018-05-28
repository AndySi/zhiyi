var stompClient = null;
$(function () {
    if (stompClient == null) {
        var socket = new SockJS('/endpointWisely'); //1
        stompClient = Stomp.over(socket);   //2
        stompClient.connect({}, function (frame) {  //3
            console.log('开始进行连接Connected: ' + frame);
            // 注册发送消息
            stompClient.subscribe(baseURL+'topic/getOrderResponse', function (rsp) { //4
                //边缘弹出
                parent.layer.open({
                    title: '温馨提示'
                    , type: 1
                    , offset: 'rb'
                    , content: '<div style="padding: 20px 80px;">有新的贷款，订单号：' + JSON.parse(rsp.body).loanNo + '</div>'
                    , btn: '关闭全部'
                    , btnAlign: 'c'
                    , shade: 0   //不显示遮罩
                    , yes: function () {
                        parent.layer.closeAll();
                    }
                });
            });
        });
    }
});

layui.use(['table', 'form', 'laytpl'], function () {
    var table = layui.table
        , form = layui.form
        , laytpl = layui.laytpl;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/order/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'orderNo', title: '订单号', width: 210}
            , {field: 'itemName', title: '商品名称'}
            , {field: 'orderNum', title: '订单数量'}
            , {field: 'orderMoney', title: '订单金额'}
            , {field: 'addressId', title: '订单地址'}
            , {field: 'nickName', title: '下单人'}
            , {field: 'receiver', title: '收货人'}
            , {field: 'tel', title: '收货人手机号码'}
            , {field: 'payType', title: '支付方式', templet: '#payTypeTpl'}
            , {field: 'createTime', title: '订单创建时间'}
            , {field: 'orderState', title: '订单状态', templet: '#stateTpl', fixed: 'right'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-200'
    });

    // 监听下拉选项框
    form.on('select(lf-orderState)', function (data) {
        vm.q.orderState = data.value;
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        console.log(JSON.stringify(vm.orderInfo));
        $.fn_ajax(null, baseURL+'sysWx/order/update', vm.orderInfo, function (r) {
            if (r.code === 0) {
                parent.layer.msg('操作成功', {
                    icon: 1
                    , time: 2000
                }, function () {
                    window.location.reload();
                });
            } else {
                alert(r.msg);
            }
        });
    });

    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                where: {
                    orderNo: vm.q.orderNo,
                    orderState: vm.q.orderState
                }
            });
        },
        goback: function () {
            window.location.reload();
        },
        update: function () {
            var row = fn_getSelectedRow(table);
            if (row) {
                vm.showEle = false;
                vm.orderInfo = row;
            }
        }
    };

    $('#vApp .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    // 自定义验证
    form.verify({
        lvRequired:function (value) {
            if(vm.itemSku.id == null && value == "") {
                return "必填项不能为空";
            }
        }
        ,lvPrice: function (value) {
            if (value == "") {
                return "必填项不能为空";
            }
            var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
            if (!reg.test(value)) {
                return "格式错误";
            }
        }
        , lvNum: function (value) {
            if (value == "") {
                return "必填项不能为空";
            }
            var reg = /^[1-9]\d*$/;
            if (!reg.test(value)) {
                return "格式错误";
            }
        }
        , lvSaleNum: function (value) {
            if (value == "") {
                return "必填项不能为空";
            }
            var reg = /^([1-9]\d*|[0]{1,1})$/;
            if (!reg.test(value)) {
                return "格式错误";
            }
        }
    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        showEle: true,
        q: {
            orderNo: null,
            orderState: ''
        },
        orderInfo: {}
    }
});

/**
 * 断开连接
 */
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}