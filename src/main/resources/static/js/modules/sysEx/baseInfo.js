layui.use(['form', 'upload'], function () {
    var form = layui.form
        , upload = layui.upload;


    // 产品封面图片上传
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

    // 产品封面图片上传
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
                $('#d-review').html('<img src="' + result + '" id="target" alt="' + file.name + '" class="layui-upload-img"/>');
            });
        }
        , done: function (res) {
            // 按扭禁用
            $('#btn-uploadCode').addClass("layui-btn-disabled");
            $('#btn-uploadCode').attr("disabled", true);
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

    });
});

var vm = new Vue({
    el: '#vApp',
    data: {
        data: {}
    }
    , methods: {
        init: function () {
            $.getJSON(baseURL + 'sysWs/baseInfo/info', function (r) {
                console.log(r);
                vm.data = r.data;
            });
        }
    }
    , created: function () {
        this.init();
    }
});