layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , laydate = layui.laydate;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/address/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'tel', title: '收货人电话号码'}
            , {field: 'uName', title: '收货人姓名'}
            , {field: 'address', title: '收货人地址'}
            , {field: 'nickName', title: '用户名称'}
            , {field: 'isDefault', title: '是否默认', templet: '#defaultTpl'}
            , {field: 'createTime', title: '创建时间'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                where: {
                    utel: vm.q.utel
                }
            });
        }
    };

    $('#vApp .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            utel: null
        }
    }
});