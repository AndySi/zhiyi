package com.idou.common.constant;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-08-02 下午 5:02
 **/

public class SysConstant {
    /**
     * 用户登录次数计数  redisKey 前缀
     */
    public static final String SHIRO_LOGIN_COUNT = "shiro_login_count_";

    /**
     * 用户登录是否被锁定,一小时 redisKey 前缀
     */
    public static final String SHIRO_IS_LOCK = "shiro_is_lock_";

    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * 菜单类型
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
