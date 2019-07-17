package cn.youguang.controller;


import cn.youguang.dto.LoginDto;
import cn.youguang.entity.User;
import cn.youguang.service.UserService;
import cn.youguang.shiro.MyUsernamePasswordToken;
import cn.youguang.util.Result;
import cn.youguang.util.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.sns.SnsToken;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @description：登录退出
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private UserService userService;


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "/Mall/Login";
    }

    /**
     * GET 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login() {
//        LOGGER.info("GET请求登录");
//        if (SecurityUtils.getSubject().isAuthenticated()) {
//            return "redirect:/index";
//        }
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg("请进行登录操作");

        return result;
    }


    /**
     * GET 登录
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/wxlogin", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
//        LOGGER.info("GET请求登录");
//        if (SecurityUtils.getSubject().isAuthenticated()) {
//            return "redirect:/index";
//        }


        return "/Mall/Login";
    }


    @RequestMapping(value = "mylogin", method = RequestMethod.GET)
    @ResponseBody
    public Result mylogin(@RequestParam(required = false) String wxcode, @RequestParam(required = false) String verifycode, @RequestParam(required = false) String username, @RequestParam String password, @RequestParam(required = false) String logintype, HttpServletRequest httpServletRequest) {


        LoginDto loginDto = new LoginDto();
        loginDto.setWxcode(wxcode);
        loginDto.setLogintype(logintype);
        loginDto.setPassword(username);
        loginDto.setUsername(password);
        loginDto.setVerifycode(verifycode);
        return loginPost(loginDto);

    }

    /**
     * POST 登录 shiro 写法
     *
     * @param username 用户名
     * @param password 密码
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings(value = "all")
    public Result loginPost(@RequestBody LoginDto loginDto) {

        LOGGER.info("POST请求登录");
        HttpServletRequest request = null;
        if (StringUtils.isNotBlank(loginDto.getVerifycode())) {
            request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        }

        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        // String loginpass = Hex.encodeHexString(password.getBytes());//变原文密码为密文密码
        String wxcode = loginDto.getWxcode();
        String logintype = loginDto.getLogintype();
        String verifycode = loginDto.getVerifycode();

        Result result = new Result();
        Subject user = SecurityUtils.getSubject();
        MyUsernamePasswordToken token = new MyUsernamePasswordToken();
        User userdb = new User();
        try {
            if ("wxlogin".equals(logintype.trim())) {
                SnsToken snsToken = SnsAPI.oauth2AccessToken(appid, secret, wxcode);
                weixin.popular.bean.user.User wxuser = SnsAPI.userinfo(snsToken.getAccess_token(), snsToken.getOpenid(), "zh_CN");

                if (wxuser.isSuccess()) {
                    userdb = userService.findByOpenid(wxuser.getOpenid());
                    if (userdb == null) {
                        userdb = userService.initUserFromWxUser(wxuser);
                        userdb = userService.saveUser(userdb);
                    }
                    token = new MyUsernamePasswordToken(userdb.getWxopenid(), userdb.getWxopenid(), logintype);
                    token.setRememberMe(true);
                    user.login(token);
                } else {
                    result.setMsg("微信获取信息失败");
                    return result;
                }
            }
            if ("khlogin".equals(logintype)) {
                if (StringUtils.isBlank(username)) {
                    result.setMsg("用户名不能为空");
                    return result;
                }
                if (StringUtils.isBlank(password)) {
                    result.setMsg("密码不能为空");
                    return result;
                }
                token = new MyUsernamePasswordToken(username.trim(), password.trim(), logintype);
                user.login(token);
            }


        } catch (Exception e) {
            result.setMsg("登录失败{ " + e.getMessage() + "}");
            return result;
        }
        result.setSuccess(true);
        result.setObj(userdb);
        return result;
    }


    /**
     * 未授权
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    @ResponseBody
    public Result unauth(Model model) {
        Result result = new Result();
        result.setObj("未授权");
        result.setSuccess(false);
        return result;
    }


    /**
     * IoException 处理页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/ioexception", method = RequestMethod.GET)
    @ResponseBody
    public Result ioexception(Model model) {
        Result result = new Result();
        result.setObj("io错误");
        result.setSuccess(false);
        return result;
    }


    /**
     * 退出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        LOGGER.info("登出");
        Subject subject = SecurityUtils.getSubject();
        Result result = new Result();
        subject.logout();
        result.setSuccess(true);
        return result;
    }


    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 10, true, Color.WHITE, Color.BLACK, null);
        request.getSession().setAttribute("verifyCode", verifyCode);
        try {
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", out);
            try {
                out.flush();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
