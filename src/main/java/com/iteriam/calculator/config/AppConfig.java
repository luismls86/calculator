package com.iteriam.calculator.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TracerImpl createTracer() {
        return new TracerImpl();
    }
}
