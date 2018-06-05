var layedit = null;
layui.use(['form', 'layedit', 'layer'], function () {
    var $ = layui.jquery
        , form = layui.form
        , layer = layui.layer;
    layedit = layui.layedit;

    //构建一个默认的编辑器
    layedit.set({
        height: 450,
        uploadImage: {
            url: baseURL + 'sysWs/wsserver/uploadImg' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('LAY_demo1');

    // 监听提交
    form.on('submit(btn-ok)', function (data) {
        vm.itemInfo.content = layedit.getContent(editIndex);
        if (layedit.getText(editIndex) == '') {
            parent.layer.msg("内容不能为空", {time: 2000, icon: 5, anim: 6});
            return;
        }
        $.fn_ajax(null, baseURL + "sysWs/wsserver/save", vm.itemInfo, function (r) {
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
            $.getJSON(baseURL + 'sysWs/wsserver/info', function (r) {
                if(r.data){
                    vm.itemInfo = r.data;
                }
            });
        }
    }
    , created: function () {
        this.init();
    }
});