package com.ajou00.solution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 경로 패턴 설정
                .allowedOrigins("*") // 허용할 origin 설정
                .allowedMethods("GET", "POST"); // 허용할 HTTP 메서드 설정
    }
}
