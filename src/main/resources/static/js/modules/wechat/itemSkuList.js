layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var table = layui.table
        , form = layui.form;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'/sysWx/itemSku/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'name', title: '商品名称', width: 360}
            , {field: 'attrInfo', title: '属性', width: 260}
            , {field: 'originalPrice', title: '原价', width: 100}
            , {field: 'price', title: '售价(￥)', width: 100}
            , {field: 'stock', title: '库存', width: 100}
            , {field: 'saleNum', title: '销量'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemSku.id == null ? baseURL+'/sysWx/itemSku/add' : baseURL+'sysWx/itemSku/update';
        console.log(JSON.stringify(vm.itemSku));
        $.fn_ajax(null, url, vm.itemSku, function (r) {
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
            vm.itemSku = {name: null, stock: 1, saleNum: 0, attrInfo: null};
            vm.showEle = false;
            vm.showUpdate = false;
            vm.title = "新增";
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            console.log(JSON.stringify(row));
            if (row) {
                vm.showEle = false;
                vm.showUpdate = true;
                vm.title = "修改";
                vm.itemSku = row;
                vm.getTree(row.attr);
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
                        url: baseURL+"sysWx/itemSku/delete",
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

    // 监听下拉选项框
    form.on('select(lf-item)', function (data) {
        vm.itemSku.attrInfo = null;
        if (data.value!='') {
            vm.itemSku.itemId = data.value;
            vm.getTree();
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
            name: "attrName",
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
        q: {
            name: null
        },
        itemSku: {
            name: null,
            stock: 1,
            saleNum: 0,
            attrInfo: null
        },
        itemList: {},
        showEle: true,
        showUpdate: true,
        title: null
    },
    methods: {
        getItemOptions: function () {
            $.getJSON(baseURL+'sysWx/item/queryAllList', function (r) {
                vm.itemList = r.data;
            });
        },
        getTree: function (attr) {
            $.get(baseURL+'sysWx/itemAttr/queryListByItemId', {itemId: vm.itemSku.itemId}, function (r) {
                ztree = $.fn.zTree.init($("#listTree"), setting, r.data);
                //展开所有节点
                ztree.expandAll(true);

                if (attr != null) {
                    var attrIds = attr.split(',');
                    for (k in attrIds) {
                        var node = ztree.getNodeByParam('id', attrIds[k]);
                        ztree.checkNode(node, true, false);
                    }
                }
            }, 'json');
        },
        getTreeBox: function () {
            if (typeof (ztree) != "undefined") {
                layer.open({
                    type: 1
                    , skin: 'layui-layer-molv'
                    , area: ['300px', '450px']
                    , offset: '100px'
                    , title: '商品属性选择'
                    , shade: 0
                    , shadeClose: false
                    , content: $('#treeLayer')
                    , btn: ['确定', '取消']
                    , yes: function (index) {
                        var nodes = ztree.getCheckedNodes();
                        var attrIdList = new Array();
                        var strTemp = "";
                        for (var i = 0; i < nodes.length; i++) {
                            attrIdList.push(nodes[i].id);
                            strTemp += nodes[i].attrName + ',';
                        }
                        strTemp = strTemp.substr(0, strTemp.length - 1);
                        vm.itemSku.attr = attrIdList.join("");
                        vm.itemSku.attrInfo = strTemp;
                        layer.close(index);
                    }
                });
            }
        }
    },
    created: function () {
        this.getItemOptions();
    }
});