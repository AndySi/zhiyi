var layedit = null;
layui.use(['table', 'form', 'laytpl', 'upload', 'layedit', 'layer'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl
        , layer = layui.layer;
    layedit = layui.layedit;

    //构建一个默认的编辑器
    layedit.set({
        uploadImage: {
            url: baseURL + 'sysWs/wsactivity/uploadCover' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('LAY_demo1');

    table.render({
        elem: '#layui-grid'
        , url: baseURL + 'sysWs/wsactivity/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID'}
            , {field: 'title', title: '标题'}
            , {field: 'typename', title: '类型'}
            , {field: 'link', title: '链接'}
            , {field: 'poll', title: '票数'}
            , {field: 'createtime', title: '创建时间'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-200'
    });

    // 监听下拉选项框
    form.on('select(lf-type)', function (data) {
        vm.q.typeid = data.value;
    });

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemInfo.id == null ? baseURL + "sysWs/wsactivity/save" : baseURL + "sysWs/wsactivity/update";
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
                content: '<img src="' + data.cover + '" height="100%" width="100%" />'
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
                where: {
                    title: vm.q.title,
                    typeid: vm.q.typeid
                }
            });
        },
        goback: function () {
            window.location.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.itemInfo = {typename: null, poll: 0};
            vm.getType();
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                $.get(baseURL + "sysWs/wsactivity/info/" + row.id, function (r) {
                    console.log(JSON.stringify(r.data));
                    if (r.code == 0) {
                        vm.showList = false;
                        vm.title = "修改";
                        vm.itemInfo = r.data;
                        $('#d-review').html('<img src="' + vm.itemInfo.cover + '" id="target" class="layui-upload-img"/>');
                        layedit.setContent(editIndex, vm.itemInfo.content, false);
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
                        url: baseURL + "sysWs/wsactivity/delete",
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
            name: "name",
            url: "noUrl"
        }
    }
};

var vm = new Vue({
    el: '#vApp',
    data: {
        q: {
            title: null,
            typeid: null
        },
        itemInfo: {
            typename: null,
            poll: 0
        },
        typeList: {},
        showList: true,
        title: null
    },
    methods: {
        getType: function () {
            //加载类型树
            ztree = $.fn.zTree.init($("#typeTree"), setting, vm.typeList);
            if (typeof (vm.itemInfo.typeid) != "undefined") {
                var node = ztree.getNodeByParam("id", vm.itemInfo.typeid);
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
                    vm.itemInfo.typeid = node[0].id;
                    vm.itemInfo.typename = node[0].name;
                    layer.close(index);
                }
            });
        },
        options: function () {
            $.getJSON(baseURL + 'sysWs/wsactivitytype/queryAllList', function (r) {
                vm.typeList = r.data;
            });
        }
    },
    created: function () {
        this.options();
    }
});