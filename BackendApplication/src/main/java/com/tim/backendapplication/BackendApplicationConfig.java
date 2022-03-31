package com.tim.backendapplication;

import com.tim.backendapplication.options.OptionService;
import com.tim.backendapplication.product.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendApplicationConfig {
    @Bean
    ProductMapper productMapper() {
        return new ProductMapper();
    }

}
