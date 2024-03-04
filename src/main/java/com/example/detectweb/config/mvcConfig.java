package com.example.detectweb.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//扩展MVC
@Configuration
public class mvcConfig implements WebMvcConfigurer {
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/detect").setViewName("detect");
        registry.addViewController("/manage").setViewName("manage");
        registry.addViewController("/top").setViewName("top");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/historyList").setViewName("historyList");
//        registry.addViewController("/History").setViewName("historyList");
        registry.addViewController("/selectPhoto").setViewName("selectPhoto");
        registry.addViewController("/photoManage").setViewName("photoManage");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login", "/",
//                        "/css/*", "/js/**", "/img/**", "/mybatis/mapper/**", "/layui/**","/favicon.ico");     // 资源
//    }
}