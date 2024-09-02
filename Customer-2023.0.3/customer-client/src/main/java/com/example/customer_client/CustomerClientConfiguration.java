package com.example.customer_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerClientConfiguration {

    @Bean
    CustomerClient customerClient(RestTemplate restTemplate) {
        return new CustomerClient(restTemplate);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

