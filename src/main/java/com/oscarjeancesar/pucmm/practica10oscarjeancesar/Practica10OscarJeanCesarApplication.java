package com.oscarjeancesar.pucmm.practica10oscarjeancesar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan
//@EnableJpaRepositories("com.oscarjeancesar.pucmm.practica10oscarjeancesar.data")
public class Practica10OscarJeanCesarApplication {
    public static void main(String[] args) {
        SpringApplication.run(Practica10OscarJeanCesarApplication.class, args);
    }

}
