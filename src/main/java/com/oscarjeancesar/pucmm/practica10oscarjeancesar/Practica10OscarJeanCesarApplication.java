package com.oscarjeancesar.pucmm.practica10oscarjeancesar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class Practica10OscarJeanCesarApplication {
    public static void main(String[] args) {
        SpringApplication.run(Practica10OscarJeanCesarApplication.class, args);
    }

}
