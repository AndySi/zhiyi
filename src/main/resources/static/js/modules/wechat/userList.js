layui.use(['table', 'form', 'laytpl'], function () {
    var table = layui.table
        , form = layui.form
        , laytpl = layui.laytpl;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/user/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', sort: true, width: 40}
            , {field: 'openId', title: '微信编码', width: 80}
            , {field: 'nickName', title: '昵称'}
            , {
                field: 'headimgurl',
                title: '头像',
                width: 100,
                templet: '#touxiangTpl',
                event: 'showImg',
                style: 'cursor: pointer;'
            }
            , {field: 'gender', title: '性别', templet: '#sexTpl', width: 60}
            , {field: 'province', title: '省份', width: 60}
            , {field: 'country', title: '城市', width: 60}
            , {field: 'subscribe', title: '是否关注', templet: '#subscribeTpl', width: 80}
            , {field: 'subscribeTime', title: '关注时间'}
            , {field: 'lastLoginTime', title: '最后登录时间'}
            , {field: 'source', title: '用户来源', templet: '#sourceTpl', width: 80}
            , {field: 'createTime', title: '创建时间', sort: true}
            , {field: 'uStatu', title: '状态', width: 60, templet: '#statuTpl', fixed: 'right'}
            , {title: '操作', fixed: 'right', align: 'center', toolbar: '#handerBar'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    /**
     * 事件定义
     */
    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                where: {
                    utel: vm.q.utel,
                    uStatu: vm.q.uStatu
                }
            });
        }
    };
    $('#vApp .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    // 监听下拉选项框
    form.on('select(lf-statu)', function (data) {
        vm.q.uStatu = data.value;
    });

    // 监听操作工具按钮
    table.on('tool(lf-user)', function (obj) {
        var data = obj.data;
        if (obj.event === 'showImg') {
            var img = data.headimgurl == null ? baseURL+'img/user.jpg' : data.headimgurl;
            parent.layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: 'auto',
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: true,
                content: '<img src="' + img + '" height="100%" width="100%">'
            });
        } else if (obj.event === 'normal') { //正常
            data.uStatu = 0;
            fn_confirm("是否恢复正常", function () {
                $.fn_ajax(null, baseURL+"sysWx/user/updateStatu", data, function (r) {
                    if (r.code === 0) {
                        parent.layer.msg('操作成功', {icon: 1}, function () {
                            active.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                })
            });
        } else if (obj.event === 'lock') {    //锁定
            data.uStatu = 1;
            //prompt层
            parent.layer.prompt({title: '锁定原因', formType: 2}, function (text, index) {
                parent.layer.close(index);
                data.remark = text;
                $.fn_ajax(null, baseURL+"sysWx/user/updateStatu", data, function (r) {
                    if (r.code === 0) {
                        parent.layer.msg('操作成功', {icon: 1}, function () {
                            active.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                })
            });
        }
    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            utel: null,
            uStatu: -1
        },
        user: {
            uStatu: 0
        }
    }
});