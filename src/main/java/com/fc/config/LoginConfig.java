package com.fc.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册LoginInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/login",
                "/captcha",
                "/login.html",
                "/400.html",
                "/500.html",
                "/**/*.js",
                "/**/*.css",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.ttf",
                "/**/*.eot",
                "/**/*.otf",
                "/**/*.svg",
                "/**/*.less",
                "/**/*.scss",
                "/**/*.jpg",
                "/**/*.ico",
                "/**/*.jpeg",
                "/**/*.png",
                "/**/*.bmp");
        registration.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
