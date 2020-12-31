package com.springboot.carstore.config;

import com.springboot.carstore.repository.CarDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    public CarDao carDao(){
        return new CarDao();
    }
    
}
