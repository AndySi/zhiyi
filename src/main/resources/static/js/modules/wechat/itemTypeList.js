layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/itemType/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '分类ID', sort: true}
            , {field: 'name', title: '分类名称'}
            , {field: 'pid', title: '父分类编号'}
            , {field: 'parentName', title: '父分类名称'}
            , {field: 'createTime', title: '创建时间'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemType.id == null ? baseURL+"sysWx/itemType/add" : baseURL+"sysWx/itemType/update";
        console.log(JSON.stringify(vm.itemType));
        $.fn_ajax(null, url, vm.itemType, function (r) {
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
            vm.showEle = true;
        },
        add: function () {
            vm.showEle = false;
            vm.title = "新增";
            vm.itemType = {parentName: null, pid: 0};
            vm.getTree();
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                vm.showEle = false;
                vm.title = "修改";
                vm.itemType = row;
                vm.getTree();
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
                        url: baseURL+"sysWx/itemType/delete",
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

var ztree;
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: -1
        },
        key: {
            name: "name",
            url: "noUrl"
        }
    }
};

var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            name: null
        },
        itemType: {
            pid: 0,
            parentName: null
        },
        showEle: true,
        title: null
    },
    methods: {
        getTree: function () {
            $.get(baseURL+"sysWx/itemType/queryAllList", function(r){
                ztree = $.fn.zTree.init($("#typeTree"), setting, r.data);
                var node = ztree.getNodeByParam("id", vm.itemType.pid);
                ztree.selectNode(node);

                vm.itemType.parentName = node.name;
            });
        },
        getTreeBox: function () {
            layer.open({
                type: 1
                , skin: 'layui-layer-molv'
                , area: ['300px', '450px']
                , offset: '100px'
                , title: '上级类型选择'
                , shade: 0
                , shadeClose: false
                , content: $("#treeLayer")
                , btn: ['确定', '取消']
                , yes: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.itemType.pid = node[0].id;
                    vm.itemType.parentName = node[0].name;

                    layer.close(index);
                }
            });
        }
    }
});