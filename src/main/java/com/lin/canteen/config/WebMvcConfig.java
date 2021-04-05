package com.lin.canteen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Override//跨域支持
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        corsRegistry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedHeaders("*");
//    }
}
