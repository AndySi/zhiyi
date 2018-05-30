layui.use(['table', 'form', 'laytpl', 'upload'], function () {
    var $ = layui.jquery
        , table = layui.table
        , form = layui.form
        , upload = layui.upload
        , laytpl = layui.laytpl;
    table.render({
        elem: '#layui-grid'
        , url: baseURL+'sysWs/wscase/list'
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'title', title: '案例标题', width: 260}
            , {field: 'pv', title: '访问量', width: 100}
            , {
                field: 'cover',
                title: '产品图片',
                templet: '#coverTpl',
                event: 'showCover',
                style: 'cursor: pointer;',
                width: 135
            }
            , {field: 'createtime', title: '创建时间', width: 160}
            , {title: '详情', fixed: 'right', width: 160, align: 'center', toolbar: '#barDemo'}
        ]]
        , id: 'idLayuiGrid'
        , page: true
        , height: 'full-120'
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
    // 详情图片上传
    var detailListView = $('#detailListView')
        , uploadListIns = upload.render({
        elem: '#btn-detail'
        , url: baseURL+'sys/oss/uploadCover'
        , auto: false   //选择文件后不自动上传
        , accept: 'images'
        , multiple: true
        , bindAction: '#btn-uploadDetail' //指向一个按钮触发上传
        , before: function (obj) {
            parent.layer.load();    //上传loading
        }
        , choose: function (obj) {
            // 按扭启用
            $('#btn-uploadDetail').removeClass("layui-btn-disabled");
            $('#btn-uploadDetail').removeAttr("disabled");
            //将每次选择的文件追加到文件队列
            var files = this.files = obj.pushFile();
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                var tr = $(['<tr id="upload-' + index + '">'
                    , '<td>' + file.name + '</td>'
                    , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                    , '<td>等待上传</td>'
                    , '<td>'
                    , '<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
                    , '<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
                    , '</td>'
                    , '</tr>'].join(''));

                //单个重传
                tr.find('.demo-reload').on('click', function () {
                    obj.upload(index, file);
                });

                //删除
                tr.find('.demo-delete').on('click', function () {
                    delete files[index]; //删除对应的文件
                    tr.remove();
                    uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                });
                detailListView.append(tr);
            });
        }
        , done: function (res, index, upload) {
            // 按扭禁用
            $('#btn-uploadDetail').addClass("layui-btn-disabled");
            $('#btn-uploadDetail').attr("disabled", true);
            if (res.code == 0) { //上传成功
                parent.layer.closeAll('loading');   //关闭loading
                vm.detailList.push(res.data.src);   // 追加到数组保存下来
                vm.itemInfo.detailArr = vm.detailList;
                var tr = detailListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                tds.eq(3).html(''); //清空操作
                return delete this.files[index];    //删除文件队列已经上传成功的文件
            }
            this.error(index, upload);
        }
        , error: function (index, upload) {
            parent.layer.closeAll('loading'); //关闭loading
            var tr = detailListView.find('tr#upload-' + index)
                , tds = tr.children();
            tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        }
    });
    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        var url = vm.itemInfo.id == null ? baseURL+"sysWx/item/add" : baseURL+"sysWx/item/update";
        if (typeof (vm.itemInfo.coverUrl) == "undefined") {
            layer.msg("请上传产品图片", {time: 2000, icon: 5, anim: 6});
            return;
        }
        if (vm.itemInfo.id == null && vm.detailList.length == 0) {
            layer.msg("请上传产品详情图片", {time: 2000, icon: 5, anim: 6});
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
                content: '<img src="' + data.coverUrl + '" height="100%" width="100%" />'
            });
        } else if (obj.event === 'detail') {   //查看
            $.getJSON(baseURL+'sysWx/item/queryDetailList', {itemId: data.id}, function (r) {
                console.log(JSON.stringify(r));
                data.detailList = r.data;
                var getTpl = detailTpl.innerHTML;
                laytpl(getTpl).render(data, function (html) {
                    //页面层
                    parent.layer.open({
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['660px', '560px'], //宽高
                        content: html
                    });
                });
            });
        }
    });

    var $ = layui.$, active = {
        reload: function () {
            table.reload('idLayuiGrid', {
                where: {
                    utel: vm.q.utel,
                    creditStatu: vm.q.creditStatu
                }
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
            vm.getType();
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
        },
        detailList: [],
        typeList: {},
        showList: true,
        title: null
    },
    methods: {
        getType: function () {
            //加载类型树
            console.log("加载类型树:" + JSON.stringify(vm.typeList));
            ztree = $.fn.zTree.init($("#typeTree"), setting, vm.typeList);
            if (typeof (vm.itemInfo.typeId) != "undefined") {
                var node = ztree.getNodeByParam("id", vm.itemInfo.typeId);
                if(node){
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
                    vm.itemInfo.typeId = node[0].id;
                    vm.itemInfo.typeName = node[0].name;
                    layer.close(index);
                }
            });
        },
        options: function () {
            $.getJSON(baseURL+'sysWs/wscasetype/queryAllList', function (r) {
                vm.typeList = r.data;
            });
        }
    },
    created: function () {
        this.options();
    }
});