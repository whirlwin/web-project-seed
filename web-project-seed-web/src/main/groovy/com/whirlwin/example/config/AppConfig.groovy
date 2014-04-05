package com.whirlwin.example.config

import com.whirlwin.example.mvc.ExampleHandlerInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.whirlwin.example")
class AppConfig extends WebMvcConfigurerAdapter {

   @Autowired
   private ExampleHandlerInterceptor exampleHandlerInterceptor

    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/")
    }

    @Override
    void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor exampleHandlerInterceptor
    }

    @Bean
    InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver()
        resolver.setPrefix "/WEB-INF/pages/"
        resolver.setSuffix ".jsp"
        resolver
    }
}
