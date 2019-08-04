package com.syedu.hrm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //告诉拦截器拦截哪些 哪些不用拦截
        //addPathPatterns()哪些URL需要拦截
        //excludepathPatterns()哪些URL不用拦截
        String[] addPathPatterns={"/**"};//表示拦截所有命令
        String[] excludepathPatterns={"/togoin","/css/**","/images/**","/js/**","/loginAjax","/verifycode"};//这些命令不用拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns(addPathPatterns).excludePathPatterns(excludepathPatterns);
    }
}
