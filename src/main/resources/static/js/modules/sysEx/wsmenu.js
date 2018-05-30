layui.use(['table', 'form'], function () {
    var $ = layui.jquery
        , form = layui.form
        , table = layui.table;
    table.render({
        elem: '#layui-grid'
        , url: baseURL + 'sysWs/wsmenu/list'
        , cols: [[
            {field: 'id', title: 'ID'}
            , {field: 'name', title: '菜单名'}
            , {field: 'sortnum', title: '排序号', sort: true}
            , {field: 'usable', title: '是否禁用', templet: '#checkboxTpl', unresize: true}
        ]]
        , id: 'idLayuiGrid'
        , page: false
        , height: 'full-120'
    });

    //监听锁定操作
    form.on('checkbox(lockDemo)', function (obj) {
        var data = "id=" + this.value + "&val=" + obj.elem.checked;
        $.ajax({
            type: "POST",
            url: baseURL + "sysWs/wsmenu/update",
            data: data,
            dataType: "json",
            success: function (r) {
                if (r.code == 0) {  //登录成功
                    parent.layer.msg('操作成功', {
                        icon: 1
                        , time: 2000
                    }, function () {
                        table.reload('idLayuiGrid', {
                            where: {}
                        });
                    });
                } else {
                    //执行重载
                    table.reload('idLayuiGrid', {
                        where: {}
                    });
                    alert(r.msg);
                }
            }
        });
    });
});