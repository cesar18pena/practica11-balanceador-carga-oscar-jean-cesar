package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;

    @RequestMapping("/")
    public String index(Locale locale){
        Usuario usuario = usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234"));
        System.out.println(usuario.getNombreUsuario());
        return "index";
    }

}
