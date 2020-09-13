package com.example.demo.config;

import com.example.demo.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
    //加上本类，静态资源会失效,需要这样补充下
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        List<String> excludePath = new ArrayList<>();
//        //排除拦截，除了注册登录(此时还没token)，其他都拦截
//        excludePath.add("/signin");  //登录
//        excludePath.add("/login");     //注册
//        excludePath.add("/validatePhone");     //验证手机号
//        excludePath.add("/static/**");  //静态资源
//        excludePath.add("/assets/**");  //静态资源

        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
//                .excludePathPatterns(excludePath);
                .excludePathPatterns("/signin","/login","/validatePhone","/error");

        super.addInterceptors(registry);
    }
}
