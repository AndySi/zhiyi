layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl;

    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWs/wsbanner/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID'}
            , {
                field: 'url',
                title: 'banner图片',
                templet: '#coverTpl',
                event: 'showCover',
                style: 'cursor: pointer;'
            }
            , {field: 'link', title: 'banner链接'}
            , {field: 'sortNum', title: '排序', sort: true}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-200'
    });

    // 监听下拉选项框
    form.on('select(lf-type)', function (data) {
        vm.q.typeId = data.value;
    });
    // 产品封面图片上传
    upload.render({
        elem: '#test10'
        , url: baseURL+'sys/oss/uploadCover'
        , auto: false   //选择文件后不自动上传
        , accept: 'images'
        , size: 260
        , bindAction: '#btn-uploadCover' //指向一个按钮触发上传
        , before: function (obj) {
            parent.layer.load();    //上传loading
        }
        , choose: function (obj) {
            // 按扭启用
            $('#btn-uploadCover').removeClass("layui-btn-disabled");
            $('#btn-uploadCover').removeAttr("disabled");
            // 预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#d-review').html('<img src="' + result + '" id="target" alt="' + file.name + '" class="layui-upload-img"/>');
            });
        }
        , done: function (res) {
            // 按扭禁用
            $('#btn-uploadCover').addClass("layui-btn-disabled");
            $('#btn-uploadCover').attr("disabled", true);
            parent.layer.closeAll('loading'); //关闭loading
            if (res.code == "0") {
                alert('上传成功', function (obj) {
                    vm.itemInfo.coverUrl = res.data.src;
                });
            } else {
                alert(res.msg);
            }
        }
        , error: function () {
            parent.layer.closeAll('loading'); //关闭loading
        }
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemInfo.id == null ? baseURL+"sysWx/item/add" : baseURL+"sysWx/item/update";
        if (typeof (vm.itemInfo.coverUrl) == "undefined") {
            layer.msg("请上传banner图片", {time: 2000, icon: 5, anim: 6});
            return;
        }
        $.fn_ajax(null, url, vm.itemInfo, function (r) {
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
                where: {}
            });
        },
        goback: function () {
            vm.showList = true;
            $('#saveAction').addClass("layui-btn-disabled");
            $('#saveAction').attr("disabled", true);
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.itemInfo = {typeName: null};
            vm.getType(0);
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                $.get(baseURL+"sysWx/item/info/" + row.id, function (r) {
                    if (r.code == 0) {
                        vm.showList = false;
                        vm.title = "修改";
                        vm.itemInfo = r.data;
                        vm.getType();
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
                        url: baseURL+"sysWx/item/delete",
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
        lvType: function (value) {
            if (vm.itemInfo.typeId == 0) {
                return '请选择商品类型';
            }
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
            name: null,
            typeId: 0
        },
        itemInfo: {
            typeName: null
        },
        detailList: [],
        typeList: {},
        showList: true,
        title: null
    },
    methods: {
        getType: function (typeId) {
            typeId = typeof (typeId) == "undefined" ? vm.itemInfo.typeId : typeId;
            //加载类型树
            console.log("加载类型树:" + JSON.stringify(vm.typeList));
            ztree = $.fn.zTree.init($("#typeTree"), setting, vm.typeList);
            var node = ztree.getNodeByParam("id", typeId);
            ztree.selectNode(node);

            vm.itemInfo.typeId = node.id;
            vm.itemInfo.typeName = node.name;
        },
        getTypeTree: function () {
            layer.open({
                type: 1
                , skin: 'layui-layer-molv'
                , area: ['300px', '450px']
                , offset: '100px'
                , title: '类型选择'
                , shade: 0
                , shadeClose: false
                , content: $("#typeLayer")
                , btn: ['确定', '取消']
                , yes: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.itemInfo.typeId = node[0].id;
                    vm.itemInfo.typeName = node[0].name;

                    layer.close(index);
                }
            });
        },
        options: function () {
            $.getJSON(baseURL+'sysWx/itemType/queryAllList', function (r) {
                vm.typeList = r.data;
            });
        }
    },
    created: function () {
        this.options();
    }
});