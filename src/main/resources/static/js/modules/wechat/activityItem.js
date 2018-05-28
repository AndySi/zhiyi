layui.use(['table', 'form'], function () {
    var table = layui.table
        , form = layui.form;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/activityItem/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'activityName', title: '活动名称'}
            , {field: 'itemName', title: '商品名称'}
            , {field: 'createTime', title: '创建时间'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var nodes = ztree.getCheckedNodes(true);
        var arr = new Array();
        for (var i = 0; i < nodes.length; i++) {
            arr.push(nodes[i].itemId);
        }
        vm.activityItem.itemIdList = arr;

        console.log(JSON.stringify(vm.activityItem));
        $.fn_ajax(null, baseURL+"sysWx/activityItem/add", vm.activityItem, function (r) {
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
            vm.initTree(null);
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
                        url: baseURL+"sysWx/activityItem/delete",
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

    // 监听下拉选项框
    form.on('select(lf-activity)', function (data) {
        if (data.value!='') {
            vm.activityItem.activityId = data.value;
        }
    });
});

var ztree;
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: 0
        },
        key: {
            name: "name",
            url: "noUrl"
        }
    },
    check: {
        enable: true,
        nocheckInherit: true
    }
};

var vm = new Vue({
    el: '#vApp',
    data: {
        showEle: true,
        title: null,
        q: {
            activityName: null
        },
        activityItem: {
            itemName: null
        },
        activityList: {}
    }
    , methods: {
        initTree: function (idsArr) {
            $.get(baseURL+'sysWx/activityItem/queryItemList', null, function (r) {
                ztree = $.fn.zTree.init($("#listTree"), setting, r.data);
                //展开所有节点
                ztree.expandAll(true);

                if (idsArr != null) {
                    var ids = idsArr.split(',');
                    for (k in ids) {
                        var node = ztree.getNodeByParam('id', ids[k]);
                        ztree.checkNode(node, true, false);
                    }
                }
            }, 'json');
        },
        getOptions: function () {
            $.getJSON(baseURL+'sysWx/activity/queryAllList', function (r) {
                vm.activityList = r.data;
            });
        }
    }
    , created: function () {
        this.getOptions();
    }
});