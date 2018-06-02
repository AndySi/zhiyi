var layedit = null;
layui.use(['table', 'form', 'laytpl', 'upload', 'layedit', 'layer'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , laytpl = layui.laytpl
        , layer = layui.layer;
    layedit = layui.layedit;

    //构建一个默认的编辑器
    layedit.set({
        uploadImage: {
            url: baseURL + 'sysWs/wsserver/uploadImg' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('LAY_demo1');

    table.render({
        elem: '#layui-grid'
        , url: baseURL + 'sysWs/wsserver/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'title', title: '案例标题'}
            , {field: 'createtime', title: '创建时间'}
            , {title: '详情', fixed: 'right', align: 'center', toolbar: '#barDemo'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
    });
    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemInfo.id == null ? baseURL + "sysWs/wsserver/save" : baseURL + "sysWs/wsserver/update";
        vm.itemInfo.content = layedit.getContent(editIndex);
        if (layedit.getText(editIndex) == '') {
            parent.layer.msg("内容不能为空", {time: 2000, icon: 5, anim: 6});
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
            vm.itemInfo = {title: null};
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if (row) {
                $.get(baseURL + "sysWs/wsserver/info/" + row.id, function (r) {
                    if (r.code == 0) {
                        vm.showList = false;
                        vm.title = "修改";
                        vm.itemInfo = r.data;
                        layedit.setContent(editIndex, vm.itemInfo.content, false);
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
                        url: baseURL + "sysWs/wsserver/delete",
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
        itemInfo: {},
        showList: true,
        title: null
    }
});