layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/attr/nameList'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '属性名编号', sort: true}
            , {field: 'name', title: '属性名'}
            , {field: 'itemTypeName', title: '商品分类名称'}
            , {field: 'parentName', title: '父属性名称'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.attrInfo.id == null ? baseURL+'sysWx/attr/addName' : baseURL+'sysWx/attr/updateName';
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
            vm.attr = {parentName: null, pid: 0};
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
                        url: baseURL+'sysWx/attr/deleteName',
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

var ztreeAttr, ztreeItemType;
var attrSetting = {
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
var itemTypeSetting = {
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
    }
};
var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            name: null
        },
        attrInfo: {
            pid: 0,
            parentName: null,
            itemTypeName: null
        },
        showEle: true,
        title: null
    },
    methods: {
        getTree: function () {
            $.get(baseURL+'sysWx/itemType/queryTreeList', function (r) {
                ztreeItemType = $.fn.zTree.init($("#typeTree"), itemTypeSetting, r.data);
                if (typeof (vm.attrInfo.itemTypeId) != "undefined") {
                    var node = ztreeItemType.getNodeByParam("id", vm.attrInfo.itemTypeId);
                    if (node) {
                        ztreeItemType.selectNode(node);

                        vm.attrInfo.itemTypeName = node.name;
                    }
                }
            });
            $.get(baseURL+'sysWx/attr/queryAllList', function (r) {
                ztreeAttr = $.fn.zTree.init($("#attrTree"), attrSetting, r.data);
                var node = ztreeAttr.getNodeByParam("id", vm.attrInfo.pid);
                if (node) {
                    ztreeAttr.selectNode(node);

                    vm.attrInfo.parentName = node.name;
                }
            });
        },
        getAttrTreeBox: function () {
            layer.open({
                type: 1
                , skin: 'layui-layer-molv'
                , area: ['300px', '450px']
                , offset: '100px'
                , title: '上级类型选择'
                , shade: 0
                , shadeClose: false
                , content: $('#attrTreeLayer')
                , btn: ['确定', '取消']
                , yes: function (index) {
                    var node = ztreeAttr.getSelectedNodes();
                    //选择上级菜单
                    vm.attrInfo.pid = node[0].id;
                    vm.attrInfo.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
        getItemTypeTreeBox: function () {
            layer.open({
                type: 1
                , skin: 'layui-layer-molv'
                , area: ['300px', '450px']
                , offset: '100px'
                , title: '上级类型选择'
                , shade: 0
                , shadeClose: false
                , content: $('#typeTreeLayer')
                , btn: ['确定', '取消']
                , yes: function (index) {
                    var node = ztreeItemType.getSelectedNodes();
                    //选择上级菜单
                    vm.attrInfo.itemTypeId = node[0].id;
                    vm.attrInfo.itemTypeName = node[0].name;

                    layer.close(index);
                }
            });
        }
    }
});