layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWx/itemAttr/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: '商品属性编号', sort: true}
            , {field: 'itemName', title: '商品'}
            , {field: 'attrName', title: '商品属性名称'}
            , {field: 'attrValue', title: '商品属性值'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemAttrInfo.id == null ? baseURL+"sysWx/itemAttr/add" : baseURL+"sysWx/itemAttr/update";
        console.log(JSON.stringify(vm.itemAttrInfo));
        $.fn_ajax(null, url, vm.itemAttrInfo, function (r) {
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
            if (row) {
                vm.showEle = false;
                vm.showUpdate = false;
                vm.title = "修改";
                console.log(JSON.stringify(row));
                vm.itemAttrInfo = row;
                vm.getTree(3);
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
                        url: baseURL+"sysWx/itemAttr/delete",
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
    form.on('select(lf-item)', function (data) {
        if (data.value != '') {
            vm.itemAttrInfo.itemId = data.value;
            vm.getTree(1);
        }
    });

    // 自定义验证
    form.verify({
        lvRequired: function (value) {
            if (vm.itemAttrInfo.id == null && value == "") {
                return "必填项不能为空";
            }
        }
    });
});

var ztreeN, ztreeV;
var settingN = {
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
var settingV = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: 0
        },
        key: {
            name: "value",
            url: "noUrl"
        }
    }
};
var vm = new Vue({
    el: '#vApp',
    data: {
        showEle: true,
        showUpdate: true,
        title: null,
        q: {
            itemName: null
        },
        itemAttrInfo: {
            itemName: null,
            attrName: null,
            attrValue: null
        },
        itemList: {}
    },
    methods: {
        getTree: function (n) {
            if (n == 1) {
                $.get(baseURL+'sysWx/attr/queryNameListByItemId', {itemId: vm.itemAttrInfo.itemId}, function (r) {
                    ztreeN = $.fn.zTree.init($("#listNameTree"), settingN, r.data);
                }, 'json');
            } else if (n == 2) {
                $.get(baseURL+'sysWx/attr/queryValueListByNameId', {nameId: vm.itemAttrInfo.attrNameId}, function (r) {
                    ztreeV = $.fn.zTree.init($("#listValueTree"), settingV, r.data);
                }, 'json');
            } else if (n == 3) {
                $.get('/sysWx/attr/queryNameListByItemId', {itemId: vm.itemAttrInfo.itemId}, function (r) {
                    ztreeN = $.fn.zTree.init($("#listNameTree"), settingN, r.data);
                    var nodeN = ztreeN.getNodeByParam("id", vm.itemAttrInfo.attrNameId);
                    if (nodeN) {
                        ztreeN.selectNode(nodeN);
                    }
                }, 'json');
                $.get(baseURL+'sysWx/attr/queryValueListByNameId', {nameId: vm.itemAttrInfo.attrNameId}, function (r) {
                    ztreeV = $.fn.zTree.init($("#listValueTree"), settingV, r.data);
                    var nodeZ = ztreeV.getNodeByParam("id", vm.itemAttrInfo.attrValueId);
                    if (nodeZ) {
                        ztreeV.selectNode(nodeZ);
                    }
                }, 'json');
            }
        },
        getTreeBox: function (n) {
            if (typeof (ztreeN) != "undefined" && n == 1) {
                layer.closeAll('page'); //关闭所有页面层
                openPage('属性名选择',$('#treeNameLayer'), function (index) {
                    var node = ztreeN.getSelectedNodes();
                    if (node.length > 0) {
                        vm.itemAttrInfo.attrNameId = node[0].id;
                        vm.itemAttrInfo.attrName = node[0].name;

                        vm.getTree(2);
                        layer.close(index);
                    }
                });
            } else if (typeof (ztreeV) != "undefined" && n == 2) {
                layer.closeAll('page'); //关闭所有页面层
                openPage('属性值选择',$('#treeValueLayer'), function (index) {
                    var node = ztreeV.getSelectedNodes();
                    if (node.length > 0) {
                        vm.itemAttrInfo.attrValueId = node[0].id;
                        vm.itemAttrInfo.attrValue = node[0].value;

                        layer.close(index);
                    }
                });
            }
        },
        getItemList: function () {
            $.getJSON(baseURL+'sysWx/item/queryAllList', function (r) {
                vm.itemList = r.data;
            });
        }
    },
    created: function () {
        this.getItemList();
    }
});