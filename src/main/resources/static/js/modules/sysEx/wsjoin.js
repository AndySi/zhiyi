var layedit = null;
layui.use(['form', 'layedit', 'layer', 'upload'], function () {
    var $ = layui.jquery
        , form = layui.form
        , upload = layui.upload
        , layer = layui.layer;
    layedit = layui.layedit;

    //构建一个默认的编辑器
    layedit.set({
        height: 450,
        uploadImage: {
            url: baseURL + 'sysWs/wsjoin/uploadImg' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('LAY_demo1');

    // 产品封面图片上传
    upload.render({
        elem: '#test10'
        , url: baseURL + 'sysWs/wsjoin/uploadImg'
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
        vm.itemInfo.content = layedit.getContent(editIndex);
        if (layedit.getContent(editIndex) == '') {
            parent.layer.msg("内容不能为空", {time: 2000, icon: 5, anim: 6});
            return;
        }
        $.fn_ajax(null, baseURL + "sysWs/wsjoin/save", vm.itemInfo, function (r) {
            if (r.code === 0) {
                parent.layer.msg('操作成功', {
                    icon: 1
                    , time: 2000
                }, function () {
                    vm.showList = true;
                });
            } else {
                alert(r.msg);
            }
        });
    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        itemInfo: {}
    },
    methods: {
        init: function () {
            $.getJSON(baseURL + 'sysWs/wsjoin/info', function (r) {
                if(r.data){
                    vm.itemInfo = r.data;
                    if(vm.itemInfo.cover!=null){
                        $('#d-review').html('<img src="' + vm.itemInfo.cover + '" id="target" class="layui-upload-img"/>');
                    }
                }
            });
        }
    }
    , created: function () {
        this.init();
    }
});