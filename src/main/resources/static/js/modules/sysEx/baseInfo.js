layui.use(['form', 'upload'], function () {
    var $ = layui.jquery
        , form = layui.form
        , upload = layui.upload;


    upload.render({
        elem: '#test10'
        , url: baseURL+'sysWs/baseInfo/uploadImg'
        , auto: false   //选择文件后不自动上传
        , accept: 'images'
        , size: 260
        , bindAction: '#btn-uploadLogo' //指向一个按钮触发上传
        , before: function (obj) {
            parent.layer.load();    //上传loading
        }
        , choose: function (obj) {
            // 按扭启用
            $('#btn-uploadLogo').removeClass("layui-btn-disabled");
            $('#btn-uploadLogo').removeAttr("disabled");
            // 预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#d-review').html('<img src="' + result + '" id="target" alt="' + file.name + '" class="layui-upload-img"/>');
            });
        }
        , done: function (res) {
            // 按扭禁用
            $('#btn-uploadLogo').addClass("layui-btn-disabled");
            $('#btn-uploadLogo').attr("disabled", true);
            parent.layer.closeAll('loading'); //关闭loading
            if (res.code == "0") {
                alert('上传成功', function (obj) {
                    vm.itemInfo.logo = res.data.src;
                });
            } else {
                alert(res.msg);
            }
        }
        , error: function () {
            parent.layer.closeAll('loading'); //关闭loading
        }
    });

    upload.render({
        elem: '#btn_qrcode'
        , url: baseURL+'sysWs/baseInfo/uploadImg'
        , auto: false   //选择文件后不自动上传
        , accept: 'images'
        , size: 260
        , bindAction: '#btn-uploadCode' //指向一个按钮触发上传
        , before: function (obj) {
            parent.layer.load();    //上传loading
        }
        , choose: function (obj) {
            // 按扭启用
            $('#btn-uploadCode').removeClass("layui-btn-disabled");
            $('#btn-uploadCode').removeAttr("disabled");
            // 预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#d-review-qrcode').html('<img src="' + result + '" id="target" alt="' + file.name + '" class="layui-upload-img"/>');
            });
        }
        , done: function (res) {
            // 按扭禁用
            $('#btn-uploadCode').addClass("layui-btn-disabled");
            $('#btn-uploadCode').attr("disabled", true);
            parent.layer.closeAll('loading'); //关闭loading
            if (res.code == "0") {
                alert('上传成功', function (obj) {
                    vm.itemInfo.qrcode = res.data.src;
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
        if (typeof (vm.itemInfo.logo) == "undefined") {
            parent.layer.msg("请上传logo", {time: 2000, icon: 5, anim: 6});
            return;
        }
        if (typeof (vm.itemInfo.qrcode) == "undefined") {
            parent.layer.msg("请上传二维码", {time: 2000, icon: 5, anim: 6});
            return;
        }
        $.fn_ajax(null, baseURL+"sysWs/baseInfo/save", vm.itemInfo, function (r) {
            if (r.code === 0) {
                parent.layer.msg('操作成功', {
                    icon: 1
                    , time: 2000
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
        itemInfo:{}
    }
    , methods: {
        init: function () {
            $.getJSON(baseURL + 'sysWs/baseInfo/info', function (r) {
                vm.itemInfo = r.data;
                if(vm.itemInfo.logo!=null){
                    console.log("-->"+vm.itemInfo.logo)
                    $('#d-review').html('<img src="' + vm.itemInfo.logo + '" id="target" class="layui-upload-img"/>');
                }

            });
        }
    }
    , created: function () {
        this.init();
    }
});