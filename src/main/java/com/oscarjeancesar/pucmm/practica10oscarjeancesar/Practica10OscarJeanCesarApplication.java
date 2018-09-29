package com.oscarjeancesar.pucmm.practica10oscarjeancesar;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.StorageProperties;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class Practica10OscarJeanCesarApplication {



    public static void main(String[] args) {

        SpringApplication.run(Practica10OscarJeanCesarApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
