package com.liuhan.smartcampus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorConfig interceptorConfig;
    private final Logger logger = LoggerFactory.getLogger(MvcConfig.class);
    /*public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("wes");
        registry.addViewController("/home").setViewName("wes");
        registry.addViewController("/login").setViewName("login");
    }*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //告知系统static 当成 静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    /**
     * 拦截器
     */


    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(interceptorConfig).addPathPatterns("/**").excludePathPatterns("/adminLogin","/adlogin","/userlogin","/common/login.html","/login", "/regist","/error","/bootstrap/**","/css/**","/image/**","/img/**","/js/**","/scss/**");
    }

}
