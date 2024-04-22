//package com.rts.ccp.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import jakarta.ws.rs.HttpMethod;
//import jakarta.ws.rs.core.HttpHeaders;
//
//
//
//@Configuration
//public class CustomWebConfig implements WebMvcConfigurer {
//    
//    @Autowired
//    JwtInterceptor jwtInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor);
//    }
//    
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedOrigins("http://localhost:4200")
////                .allowedMethods("GET", "POST", "PUT", "DELETE")
////                .allowedHeaders(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION)
////                .allowCredentials(true)
////                .maxAge(3600);
////    }
//}
//
//
//
//
