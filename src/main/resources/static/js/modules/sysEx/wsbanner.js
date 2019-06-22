layui.use(['table', 'form', 'laytpl', 'upload', 'layer'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl;


    table.render({
        elem: '#layui-grid'
        , url: baseURL + 'sysWs/wsbanner/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID'}
            , {field: 'title', title: '案例链接'}
            , {
                field: 'url',
                title: 'banner',
                templet: '#coverTpl',
                event: 'showCover',
                style: 'cursor: pointer;',
                align: 'center'
            }
            , {field: 'sortnum', title: '排序', sort: true}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-200'
    });

    // 产品封面图片上传
    upload.render({
        elem: '#test10'
        , url: baseURL + 'sysWs/wsbanner/uploadImg'
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
                    vm.itemInfo.url = res.data.src;
                });
            } else {
                alert(res.msg);
            }
        }
        , error: function () {
            parent.layer.closeAll('loading'); //关闭loading
        }
    });
    // 产品封面图片上传
    upload.render({
        elem: '#test11'
        , url: baseURL + 'sysWs/wsbanner/uploadImg'
        , auto: false   //选择文件后不自动上传
        , accept: 'images'
        , size: 260
        , bindAction: '#btn-uploadCover-tel' //指向一个按钮触发上传
        , before: function (obj) {
            parent.layer.load();    //上传loading
        }
        , choose: function (obj) {
            // 按扭启用
            $('#btn-uploadCover-tel').removeClass("layui-btn-disabled");
            $('#btn-uploadCover-tel').removeAttr("disabled");
            // 预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#d-review-tel').html('<img src="' + result + '" id="target" alt="' + file.name + '" class="layui-upload-img"/>');
            });
        }
        , done: function (res) {
            // 按扭禁用
            $('#btn-uploadCover-tel').addClass("layui-btn-disabled");
            $('#btn-uploadCover-tel').attr("disabled", true);
            parent.layer.closeAll('loading'); //关闭loading
            if (res.code == "0") {
                alert('上传成功', function (obj) {
                    vm.itemInfo.mobileurl = res.data.src;
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
        if (vm.itemInfo.link == '') {
            vm.itemInfo.link = '#';
        }
        var url = vm.itemInfo.id == null ? baseURL + "sysWs/wsbanner/save" : baseURL + "sysWs/wsbanner/update";
        if (typeof (vm.itemInfo.url) == "undefined") {
            parent.layer.msg("请上传Banner(大图)", {time: 2000, icon: 5, anim: 6});
            return;
        }
        $.fn_ajax(null, url, vm.itemInfo, function (r) {
            if (r.code === 0) {
                parent.layer.msg('操作成功', {
                    icon: 1
                    , time: 2000
                }, function () {
                    vm.showList = true;
                    active.reload();
                });
            } else {
                alert(r.msg);
            }
        });
    });
    // 监听操作工具按钮
    table.on('tool(lf-credit)', function (obj) {
        var data = obj.data;
        if (obj.event === 'showCover') {
            parent.layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: 'auto',
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: true,
                content: '<img src="' + data.url + '" height="100%" width="100%" />'
            });
        } else if (obj.event === 'detail') {   //查看
            var getTpl = detailTpl.innerHTML;
            laytpl(getTpl).render(data, function (html) {
                //页面层
                var lyIndex = layer.open({
                    type: 1,
                    area: ['660px', '560px'], //宽高
                    maxmin: true,
                    content: html
                });
                layer.full(lyIndex);
            });
        }
    });

    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
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
            vm.itemInfo = {title: null, sortnum: 0};
            $('#d-review').html('');
            vm.getType();
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                $.get(baseURL + "sysWs/wsbanner/info/" + row.id, function (r) {
                    if (r.code == 0) {
                        vm.showList = false;
                        vm.title = "修改";
                        vm.itemInfo = r.data;
                        $('#d-review').html('<img src="' + vm.itemInfo.url + '" id="target" class="layui-upload-img"/>');
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
                        url: baseURL + "sysWs/wsbanner/delete",
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
            if (vm.itemInfo.typeid == 0) {
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
            name: "title",
            url: "noUrl"
        }
    }
};

var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            title: null,
            typeid: 0
        },
        itemInfo: {
            sortnum: 0
        },
        typeList: {},
        showList: true,
        title: null
    },
    methods: {
        getType: function () {
            //加载类型树
            ztree = $.fn.zTree.init($("#typeTree"), setting, vm.typeList);
            if (typeof (vm.itemInfo.link) != "undefined") {
                var node = ztree.getNodeByParam("id", vm.itemInfo.link);
                if (node) {
                    ztree.selectNode(node);
                }
            }
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
                    vm.itemInfo.link = node[0].id;
                    vm.itemInfo.title = node[0].title;
                    layer.close(index);
                }
            });
        },
        options: function () {
            $.getJSON(baseURL + 'sysWs/wsbanner/getCaseList', function (r) {
                vm.typeList = r.data;
            });
        }
    },
    created: function () {
        this.options();
    }
});