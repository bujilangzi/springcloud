package com.atgui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Applicationconfig {
    @Bean
    @LoadBalanced
    public RestTemplate gettemplate(){
        return new RestTemplate();
    }
}
