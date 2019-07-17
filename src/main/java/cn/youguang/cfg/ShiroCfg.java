package cn.youguang.cfg;

import cn.youguang.shiro.UserCredentialsMatcher;
import cn.youguang.shiro.UserRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 可以选择性的将此类注释掉 @Configuration注释掉即可
 * Created by Andy丶 on 2017/2/20.
 */


@Configuration
public class ShiroCfg {

    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();


    @Bean("userRealm")
    public UserRealm getUserRealm() {


        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(getUserCredentialsMatcher());

        return userRealm;


    }



    @Bean("userCredentialsMatcher")
    public UserCredentialsMatcher getUserCredentialsMatcher() {
        return new UserCredentialsMatcher();
    }


    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        List<Realm> realms = new ArrayList<>();
        realms.add(getUserRealm());
        dwsm.setRealms(realms);
        dwsm.setCacheManager(getEhCacheManager());
    //    dwsm.setRememberMeManager(rememberMeManager());
        return dwsm;
    }


    /**
     * 记住我设置
     *
     * @return
     */

//    @Bean
//    public SimpleCookie rememberMeCookie() {
//
//        System.out.println("ShiroConfiguration.rememberMeCookie()");
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }
//
//    /**
//     * cookie管理对象;
//     *
//     * @return
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager() {
//
//        System.out.println("ShiroConfiguration.rememberMeManager()");
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        return cookieRememberMeManager;
//    }


    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /* *
     * 一个神奇的地方若 将       filterChainDefinitionMap.put("/login", "anon"); 放在        filterChainDefinitionMap.put("/**", "authc"); 的后面
     * 那么将需要点两次登录按钮
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
//        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/wxlogin", "anon");
        filterChainDefinitionMap.put("/verifyCode", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        //       filterChainDefinitionMap.put("/**", " authc");
//        filterChainDefinitionMap.put("/js*//**//**", "anon");
        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }


}
