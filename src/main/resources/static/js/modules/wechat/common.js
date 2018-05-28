/**
 * Created by ZhangSi on 2017/4/27 0027.
 */
(function ($, own) {
    $.extend({
        /**
         * handlebars模块引擎
         * @param scriptId  模板ID
         * @param data  json数据
         * @param el    绑定元素ID
         */
        handlebars: function (scriptId, data, el) {
            //用jquery获取模板
            var tpl = $(scriptId).html();
            //预编译模板
            var template = Handlebars.compile(tpl);
            //匹配json内容
            var html = template(data);
            //输入模板
            $(el).html(html);
        },
        /**
         * 自定义ajax插件
         * @param url
         * @param data
         * @param async
         * @param type
         * @param dataType
         * @param successfn
         * @param errorfn
         */
        fn_ajax: function (type, url, data, successfn, errorfn) {
            type = (type == null || type == "" || typeof(type) == "undefined") ? "post" : type;
            errorfn = errorfn || $.noop;
            $.ajax({
                type: type,
                url: url,
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (r) {
                    return successfn(r);
                },
                error: function (e) {
                    return errorfn(e);
                }
            });
        }
    });

    /**
     * 对浏览器窗口调整大小进行计数
     */
    $(own).on('resize', function () {
    }).resize();

    /**
     * 重写alert - layui
     * @param msg
     * @param callback
     */
    own.alert = function (msg, callback) {
        parent.layer.alert(msg, function (index) {
            parent.layer.close(index);
            if (typeof(callback) === "function") {
                return callback("ok");
            }
        });
    };

    /**
     * 提示
     */
    own.msg = function (msg, callback) {
        callback = callback || $.noop;
        parent.layer.msg(msg, {
            time: 2000
        }, function () {
            return callback();
        });
    };

    /**
     * 弹出层
     */
    own.openPage = function (title, elem, callback) {
        layer.open({
            type: 1
            , skin: 'layui-layer-molv'
            , area: ['300px', '450px']
            , offset: '100px'
            , title: title
            , shade: 0
            , shadeClose: false
            , content: elem
            , btn: ['确定', '取消']
            , yes: function (index) {
                return callback(index);
            }
        });
    }
})(jQuery, window);


/**
 * 选择一条记录-layui
 */
function fn_getSelectedRow(tb) {
    var checkStatus = tb.checkStatus('idLayuiGrid')
        , data = checkStatus.data;
    if (data.length == 0) {
        parent.layer.msg('请选择一条记录');
        return false;
    }
    if (data.length > 1) {
        parent.layer.msg('请选择单条记录');
        return false;
    }
    return data[0];
}

/**
 * 选择多条记录-layui
 * @param tg
 */
function fn_getSelectedRows(tb) {
    var checkStatus = tb.checkStatus('idLayuiGrid')
    return checkStatus.data;
}

/**
 * 选择一条记录-jqGrid
 * @returns {*}
 */
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        parent.layer.alert("请选择一条记录");
        return;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        parent.layer.alert("只能选择一条记录");
        return;
    }

    return selectedIDs[0];
}

/**
 * 选择多条记录-jqGrid
 * @returns {*}
 */
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        parent.layer.alert("只能选择一条记录");
        return;
    }

    return grid.getGridParam("selarrrow");
}

/**
 * 询问框
 * @param msg
 * @param callback
 */
function fn_confirm(msg, callback) {
    parent.layer.confirm(msg, {
        btn: ['是', '否'], //按钮
        title: '提示'
    }, function () {
        callback();
    });
}
/**
 * tip提示
 * @param msg 提示信息
 * @param ele 绑定元素ID
 * @param type 方向
 * @param color 颜色
 * @param time 时间
 */
function fn_tips(msg, ele, type, color, time) {
    time = (time == null || time == '' || typeof (time) == 'undefined') ? "1000" : time;
    color = (color == null || color == '' || typeof (color) == 'undefined') ? "#1ABC9C" : color;
    layer.tips(msg, ele, {
        tips: [type, color],
        time: time
    });
}

/**
 * jcrop图片裁剪
 *
 * @param ele 绑定元素 #target
 * @param minW 最小宽度 240
 * @param minH 最小高度 160
 * @param ratio 例：3 / 2
 */
function openJcrop(ele, minW, minH, ratio) {
    $(ele).Jcrop({
        bgFade: true,
        bgOpacity: .5,
        minSize: [minW, minH],
        aspectRatio: ratio,
        setSelect: [10, 10, minW, minH],
        onChange: updatePreview,
        onSelect: updatePreview
    }, function () {
        jcrop_api = this;
    });
}
function updatePreview(c) {
    $('#x').val(c.x);
    $('#y').val(c.y);
    $('#w').val(c.w);
    $('#h').val(c.h);
}

/*************************************JS判断客户端是手机还是PC的**************************************/
function uaredirect(f) {
    try {
        if (document.getElementById("bdmark") != null) {
            return
        }
        var b = false;
        if (arguments[1]) {
            var e = window.location.host;
            var a = window.location.href;
            if (isSubdomain(arguments[1], e) == 1) {
                f = f + "/#m/" + a;
                b = true
            } else {
                if (isSubdomain(arguments[1], e) == 2) {
                    f = f + "/#m/" + a;
                    b = true
                } else {
                    f = a;
                    b = false
                }
            }
        } else {
            b = true
        }
        if (b) {
            var c = window.location.hash;
            if (!c.match("fromapp")) {
                if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios|SymbianOS)/i))) {
                    location.replace(f)
                }
            }
        }
    } catch (d) {
    }
}
function isSubdomain(c, d) {
    this.getdomain = function (f) {
        var e = f.indexOf("://");
        if (e > 0) {
            var h = f.substr(e + 3)
        } else {
            var h = f
        }
        var g = /^www\./;
        if (g.test(h)) {
            h = h.substr(4)
        }
        return h
    };
    if (c == d) {
        return 1
    } else {
        var c = this.getdomain(c);
        var b = this.getdomain(d);
        if (c == b) {
            return 1
        } else {
            c = c.replace(".", "\\.");
            var a = new RegExp("\\." + c + "$");
            if (b.match(a)) {
                return 2
            } else {
                return 0
            }
        }
    }
}