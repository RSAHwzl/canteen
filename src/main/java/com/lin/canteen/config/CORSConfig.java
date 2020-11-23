package com.lin.canteen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {

//    @Override//跨域支持
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        corsRegistry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedHeaders("*");
//    }
}
