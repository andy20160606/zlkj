package cn.youguang.shiro;


import cn.youguang.entity.Resource;
import cn.youguang.entity.Role;
import cn.youguang.entity.User;
import cn.youguang.service.RoleService;
import cn.youguang.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的指定Shiro验证用户登录的类
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 为当前登录的Subject授予角色和权限
     */
    @Override
    @SuppressWarnings("all")
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()

        List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();
        // 从数据库中获取当前登录用户的详细信息
        System.out.println("从数据库中获取当前登录用户的详细信息");
        User user = userService.findUserById((Long) super.getAvailablePrincipal(principals));
        //System.out.println("当前登录用户信息="+user);
        if (null != user) {
            // 实体类User中包含有用户角色的实体类信息
            if (null != user.getRoles() && user.getRoles().size() > 0) {
                // 获取当前登录用户的角色
                System.out.println("获取当前登录用户的角色");
                for (Role role : user.getRoles()) {
                    roleList.add(role.getName());
                    // 实体类Role中包含有角色权限的实体类信息
                    System.out.println("实体类Role中包含有角色权限的实体类信息:" + role.getName() + ",该角色资源数量：" + role.getRess().size());
                    if (null != role.getRess() && role.getRess().size() > 0) {
                        // 获取权限
                        for (Resource res : role.getRess()) {
                            if (StringUtils.isNotEmpty(res.getUrl())) {
                                permissionList.add(res.getUrl());
                                System.out.println("permission=" + res.getUrl());
                            }
                        }
                    }
                }
            }
        } else {
            throw new AuthorizationException();
        }
        // //为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);
        simpleAuthorInfo.addStringPermissions(permissionList);
        // 实际中可能会像上面注释的那样从数据库取得
        // 权限授权时可使用通配符，或前缀匹配
//		simpleAuthorInfo.addStringPermission("/user/delete");
//		simpleAuthorInfo.addStringPermission("sys:*");
        return simpleAuthorInfo;

    }

    /**
     * 验证当前登录的Subject
     *
     * @see :本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */

    @Override
    @SuppressWarnings("all")
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        System.out.println("Shiro开始登录认证");
        MyUsernamePasswordToken token = (MyUsernamePasswordToken) authcToken;
        String loginType = token.getLoginType();
        String loginname = token.getUsername();
        String password = String.valueOf(token.getPassword());
        User user = null;
        if (loginType.equals("wxlogin")) {
            user = userService.findByOpenid(String.valueOf(token.getPassword()));
        } else if (loginType.equals("ptlogin")) {
            user = userService.findUserByLoginName(loginname);
        }
        // 账号不存在
        if (user == null) {
            System.out.println("账号不存在");
            throw new UnknownAccountException();
        }
        // 账号未启用
        if (user.getStatus() != null && 1 == user.getStatus()) {
            System.out.println("账号未启用");
            throw new DisabledAccountException();
        }
        // 认证缓存信息
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getId(), user.getLoginpass(), getName());

        //  this.setSession("currentUser", user);
        return authcInfo;

        // 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常

    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *
     * @see
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
