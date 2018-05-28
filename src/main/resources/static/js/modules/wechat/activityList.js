layui.use(['table', 'form', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , laydate = layui.laydate;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/activity/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'name', title: '活动名称'}
            , {field: 'startTime', title: '开始时间'}
            , {field: 'endTime', title: '结束时间'}
            , {field: 'sendTime', title: '发货时间'}
            , {field: 'createTime', title: '创建时间'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.activityInfo.id == null ? "/sysWx/activity/add" : "/sysWx/activity/update";
        console.log(JSON.stringify(vm.activityInfo));
        $.post(url, {params: JSON.stringify(vm.activityInfo)}, function (r) {
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
                    name: vm.q.name
                }
            });
        },
        goback: function () {
            window.location.reload();
        },
        add: function () {
            vm.showEle = false;
            vm.title = "新增";
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            console.log(JSON.stringify(row));
            if (row) {
                vm.showEle = false;
                vm.title = "修改";
                vm.timeRange = row.startTime +" ~ " + row.endTime;
                vm.activityInfo = row;
            }
        },
        delete: function () {
            var rows = fn_getSelectedRows(table);
            if (rows.length > 0) {
                var ids = [];
                for (var i = 0; i < rows.length; i++) {
                    ids[i] = rows[i].id;
                }
                fn_confirm('确定要删除选中的记录？', function () {
                    $.ajax({
                        type: "POST",
                        url: "/sysWx/activity/delete",
                        dataType: "json",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function (r) {
                            if (r.code === 0) {
                                alert('操作成功', function (index) {
                                    active.reload();
                                });
                            } else {
                                alert(r.msg);
                            }
                        }
                    });
                });
            } else {
                parent.layer.msg('请选择一条记录');
            }
        }
    };
    $('#vApp .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //日期时间范围
    laydate.render({
        elem: '#inpTime'
        , type: 'datetime'
        , trigger: 'click'
        , range: '~'
        , min: 1
        , max: 2
        , done: function (value) {
            var timeArr = value.split('~');
            vm.activityInfo.startTime = timeArr[0].replace( /(^\s*)|(\s*$)/g, "");
            vm.activityInfo.endTime = timeArr[1].replace( /(^\s*)|(\s*$)/g, "");
        }
    });
    laydate.render({
        elem: '#inpSendTime'
        , type: 'datetime'
        , min: 2
        , trigger: 'click'
        , btns: ['clear', 'confirm']
        , done: function (value) {
            vm.activityInfo.sendTime = value;
        }
    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        showEle: true,
        title: null,
        q: {
            name: null
        },
        activityInfo: {},
        timeRange: null
    }
});