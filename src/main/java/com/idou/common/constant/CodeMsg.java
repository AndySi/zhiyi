package com.idou.common.constant;

/**
 * 返回消息统一定义
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-04-13 下午 3:42
 **/

public class CodeMsg {
    private int code;
    private String msg;
    // 通用模块 5001XX
    public static CodeMsg SUCCESS = new CodeMsg(0, "成功");
    public static CodeMsg FAIL = new CodeMsg(500100, "服务端异常");
    public static CodeMsg UNKNOWN_ERROR = new CodeMsg(5001001, "未知异常，请联系管理员");
    public static CodeMsg BIND_ERROR = new CodeMsg(500102, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500103, "请求非法");
    public static CodeMsg DATA_ALREADY = new CodeMsg(500104, "数据库中已存在该记录");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500105, "访问太频繁！");
    // 登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PWD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    //秒杀模块 5005XX
    public static CodeMsg KILL_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_KILL = new CodeMsg(500501, "不能重复秒杀");
    public static CodeMsg KILL_FAIL = new CodeMsg(500502, "秒杀失败");
    // 图片模块 60000X
    public static CodeMsg FILE_NOT_NULL = new CodeMsg(500502, "文件不能为空");
    public static CodeMsg FILE_UPLOAD_FAIL = new CodeMsg(500502, "文件上传失败");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String fillArgs(Object... args){
        return String.format(CodeMsg.BIND_ERROR.getMsg(), args);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
