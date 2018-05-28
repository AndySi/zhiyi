package com.idou.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	/**
	 * layui分页结果封装
	 *
	 * @param count 数据总量
	 * @param list  数据
	 * @return
	 */
	public static R page(int count, List<?> list) {
		R r = new R();
		r.put("count", count);
		r.put("data", list);
		return r;
	}

	/**
	 * layui返回json封装
	 *
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static R layuiJson(int code, String msg, JSONObject data) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		r.put("data", data);
		return r;
	}
}
