package com.idou.modules.sysBs.authc;

import com.idou.modules.sysBs.entity.SysUserEntity;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-06-15 上午 11:33
 **/

public class PasswordEncry {
    //随机数生成器
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //指定散列算法为md5
    private static String algorithmName = "md5";
    //散列迭代次数
    private static int hashIterations = 2;

    public static void encryptPassword(SysUserEntity user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        System.out.println(user.getSalt()+"===="+user.getPassword());
        String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes("eb97d8855d83308471e93df8ee214292"), hashIterations).toHex();
        user.setPassword(newPassword);
    }

    public static void main(String[] args) {
        SysUserEntity user = new SysUserEntity();
        user.setUsername("admin");
        user.setPassword("123456");
        PasswordEncry.encryptPassword(user);
        System.out.println(user.getPassword()+"======"+user.getSalt());
    }
}
