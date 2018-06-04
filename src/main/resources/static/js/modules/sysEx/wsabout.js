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
        height: 450,
        uploadImage: {
            url: baseURL + 'sysWs/wsabout/uploadContent' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('LAY_demo1');

    table.render({
        elem: '#layui-grid'
        , url: baseURL + 'sysWs/wsabout/getList'
        , cellMinWidth: 80
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', sort: true}
            , {field: 'title', title: '标题'}
            , {title: '详情', fixed: 'right', align: 'center', toolbar: '#barDemo'}
        ]]
        , id: 'idLayuiGrid'
        , page: false
    });

    // 监听操作工具按钮
    table.on('tool(lf-credit)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {   //查看
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

    // 产品封面图片上传
    upload.render({
        elem: '#test10'
        , url: baseURL + 'sysWs/wsabout/uploadImg'
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
                    vm.itemInfo.cover = res.data.src;
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
        var url = vm.itemInfo.id == null ? baseURL + "sysWs/wsabout/save" : baseURL + "sysWs/wsabout/update";
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

    $('#vApp .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                where: {}
            });
        },
        goback: function () {
            vm.showList = true;
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.itemInfo = {};
            layedit.setContent(editIndex, '', false);
        },
        update: function () {    //修改
            var row = fn_getSelectedRow(table);
            if(row){
                vm.showList = false;
                vm.title = "修改";
                vm.itemInfo = row;
                layedit.setContent(editIndex, row.content, false);
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
                        url: baseURL + "sysWs/wsabout/delete",
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
});

var vm = new Vue({
    el: '#vApp',
    data: {
        itemInfo: {},
        showList: true,
        title: null
    },
    methods: {
        init: function () {
            $.getJSON(baseURL + 'sysWs/wsabout/getInfo', function (r) {
                $('#d-review').html('<img src="' + r.data.cover + '" id="target" class="layui-upload-img"/>');
            });
        }
    }
    , created: function () {
        this.init();
    }
});