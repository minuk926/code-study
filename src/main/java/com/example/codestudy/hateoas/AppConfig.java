package com.example.codestudy.hateoas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lim, Jong Uk (minuk926)
 * @since 2021-07-30
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public CustomPagedResourceAssembler<?> customPagedResourceAssembler(){
        return new CustomPagedResourceAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(), 10);
    }
}
