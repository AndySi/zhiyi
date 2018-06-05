layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl;

    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWs/wsactivitytype/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID'}
            , {field: 'name', title: '类型名称'}
            , {field: 'sortnum', title: '排序', sort: true}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-200'
    });

    // 监听提交
    form.on('submit(btn-ok)', function () {
        var url = vm.item.id == null ? baseURL+"sysWs/wsactivitytype/save" : baseURL+"sysWs/wsactivitytype/update";
        $.fn_ajax(null, url, vm.item, function (r) {
            if (r.code === 0) {
                parent.layer.msg('操作成功', {
                    icon: 1
                    , time: 2000
                }, function () {
                    vm.showList = true;
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
                where: {}
            });
        },
        goback: function () {
            vm.showList = true;
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.item.name = null;
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                $.get(baseURL+"sysWs/wsactivitytype/info/" + row.id, function (r) {
                    if (r.code == 0) {
                        vm.showList = false;
                        vm.title = "修改";
                        vm.item = r.data;
                    } else {
                        alert(r.msg);
                    }
                }, 'json');
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
                        url: baseURL+"sysWs/wsactivitytype/delete",
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
});

var vm = new Vue({
    el: '#vApp',
    data: {
        item: {
            name: null,
            sortnum: 0
        },
        showList: true,
        title: null
    }
});