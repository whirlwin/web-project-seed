package com.whirlwin.example.config

import org.constretto.ConstrettoBuilder
import org.constretto.ConstrettoConfiguration
import org.constretto.model.Resource
import org.constretto.spring.ConfigurationAnnotationConfigurer
import org.constretto.spring.annotation.Environment
import org.constretto.spring.internal.resolver.DefaultAssemblyContextResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@Environment
class ConstrettoConfig {

    @Bean
    ConstrettoConfiguration constrettoConfiguration() {
        new ConstrettoBuilder().createPropertiesStore().addResource(
                Resource.create("classpath:/properties.properties")).done().getConfiguration()
    }

    @Bean
    ConfigurationAnnotationConfigurer configurationAnnotationConfigurer(ConstrettoConfiguration configuration) {
        new ConfigurationAnnotationConfigurer(configuration, new DefaultAssemblyContextResolver());
    }
}
