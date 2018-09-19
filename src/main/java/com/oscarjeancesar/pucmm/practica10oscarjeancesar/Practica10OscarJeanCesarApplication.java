package com.oscarjeancesar.pucmm.practica10oscarjeancesar;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.UsuarioRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class Practica10OscarJeanCesarApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practica10OscarJeanCesarApplication.class, args);
    }

}
