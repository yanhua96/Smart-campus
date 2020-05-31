package com.liuhan.smartcampus.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    // 创建ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager); // 设置安全管理器
        /**
         * anon 无需认证就可以访问
         * authc 必须认证了才可以访问
         * user 必须拥有记住我功能才能使用
         * perms 拥有对某个资源的权限才能访问
         * role： 拥有某个角色权限才能访问
         */
        /*Map<String, String> filterMap = new LinkedHashMap<>();
        //设置授权
        filterMap.put("/test", "perms[普通]");
        filterMap.put("/test1", "perms[会员]");
        //设置拦截
        filterMap.put("/page/*", "authc");
        //设置放行
        filterMap.put("/login", "anon");
        filterMap.put("/main", "anon");
        filterMap.put("/", "anon");
        bean.setFilterChainDefinitionMap(filterMap);	//设置拦截页面和过滤器
        bean.setLoginUrl("/login");   				//设置跳转页面
        bean.setUnauthorizedUrl("/unAuthorized"); 	//设置未授权页面*/
        return bean;
    }
    // 创建DefaultWebSecurityManager
    @Bean(name = "getDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);    // 关联Realm
        return securityManager;
    }
    // 创建Realm
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
    // 配置ShiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
