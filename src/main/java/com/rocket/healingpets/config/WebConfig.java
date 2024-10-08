package com.rocket.healingpets.config;

import com.rocket.healingpets.auth.filter.HeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    // 정적 자원에 대해 url을 요청하고, 접근을 허용
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/", "classpath:/public/",
            "classpath:/", "classpath:/resources/", "classpath:/META-INF/resources/","classpath:/uploads/",
            "classpath:/META-INF/resources/webjars/", "classpath:/static/uploads/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

    }

        @Bean
        public HeaderFilter createHeaderFilter() {
            return new HeaderFilter();
        }
}

