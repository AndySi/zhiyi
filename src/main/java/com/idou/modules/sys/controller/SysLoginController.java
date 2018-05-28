package com.idou.modules.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.idou.common.constant.RetConstant;
import com.idou.common.constant.SysConstant;
import com.idou.common.utils.R;
import com.idou.common.utils.ShiroUtils;
import com.idou.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 登录相关
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
public class SysLoginController extends AbstractController {
    @Autowired
    private Producer producer;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 验证码
     */
    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public Map<String, Object> login(String username, String password, String captcha) throws IOException {
        //本项目已实现，前后端完全分离，但页面还是跟项目放在一起了，所以还是会依赖session
        //如果想把页面单独放到nginx里，实现前后端完全分离，则需要把验证码注释掉(因为不再依赖session了)
        if (StringUtils.isEmpty(captcha)) {
            return R.error(RetConstant.NULL_CAPTCHA, "验证码不能为空");
        }
        String kaptcha = ShiroUtils.getKaptcha(KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return R.error(RetConstant.ERROR_CAPTCHA, "验证码不正确");
        }
        if (StringUtils.isEmpty(username)) {
            return R.error(RetConstant.NULL_NAME, "用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return R.error(RetConstant.NULL_PWD, "密码不能为空");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(RetConstant.ERROR_NAME, "账号或密码不正确");
        } catch (IncorrectCredentialsException e) {
            return R.error(RetConstant.ERROR_PWD, "账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error(RetConstant.LOCK_ACCT, e.getMessage());
        } catch (DisabledAccountException e) {
            return R.error(RetConstant.LOCK_ACCT, e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        // 成功后删除失败次数，不再进行累加
        stringRedisTemplate.delete(SysConstant.SHIRO_LOGIN_COUNT + username);
        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping(value = "/sys/logout", method = RequestMethod.POST)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }

}
