layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/attr/valueList'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '分类ID', sort: true}
            , {field: 'value', title: '属性值'}
            , {field: 'name', title: '属性名'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.attrInfo.id == null ? baseURL+"sysWx/attr/addValue" : baseURL+"sysWx/attr/updateValue";
        console.log(JSON.stringify(vm.attrInfo));
        $.fn_ajax(null, url, vm.attrInfo, function (r) {
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
            vm.attrInfo = {name: null, pid: 0};
            vm.getTree();
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                vm.showEle = false;
                vm.title = "修改";
                vm.attrInfo = row;
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
                        url: baseURL+"sysWx/attr/deleteValue",
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
        attrInfo: {
            nameId: 0,
            name: null
        },
        showEle: true,
        title: null
    },
    methods: {
        getTree: function () {
            $.get(baseURL+"sysWx/attr/queryAllList", function(r){
                ztree = $.fn.zTree.init($("#nameTree"), setting, r.data);
                var node = ztree.getNodeByParam("id", vm.attrInfo.nameId);
                if(node && node.id != 0){
                    ztree.selectNode(node);

                    vm.attrInfo.name = node.name;
                }
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
                    if(node[0].id == 0){
                        return;
                    }
                    //选择上级菜单
                    vm.attrInfo.nameId = node[0].id;
                    vm.attrInfo.name = node[0].name;

                    layer.close(index);
                }
            });
        }
    }
});