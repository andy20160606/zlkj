package cn.youguang.shiro;

import cn.youguang.entity.User;
import cn.youguang.service.UserService;
import cn.youguang.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URL;

public class UserCredentialsMatcher extends SimpleCredentialsMatcher {


    @Autowired
    private UserService userService;

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Value("${youguang.center.yxgj.domain}")
    private String domain;


    public boolean wxConnect(String wxopenid) {
        return true;
    }


    public boolean khConnect(String khwybs, String lsrzm) {
        Result result = new Result();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(new URL(domain + "/khLsrz?khwybs=" + khwybs + "&lsrzm=" + lsrzm), Result.class);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();


        }
        return result.isSuccess();
    }


    @Override
    @SuppressWarnings(value = "all")
    public boolean doCredentialsMatch(AuthenticationToken token,
                                      AuthenticationInfo info) {
        MyUsernamePasswordToken upt = (MyUsernamePasswordToken) token;
        String user = upt.getUsername();
        String pass = String.valueOf(upt.getPassword());
        String loginType = upt.getLoginType();


        if (loginType.equals("wxlogin")) {  //如果是微信标识登录
            return wxConnect(pass);
        }

        if (loginType.equals("khlogin")) {
            return khConnect(user, pass);
        }


//        if (loginType.equals("khlogin")) {
//            return khConnect(user, pass);
//        }

//		if ("root".equals(user) && "pass".equals(pass))
//			return true;
//		else
//			return connect("121.41.41.30", "389", user, pass);

        return false;
    }


}
