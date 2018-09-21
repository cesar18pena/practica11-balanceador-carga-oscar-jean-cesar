package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model, Locale locale){
        Usuario usuario = usuarioService.crearUsuario(new Usuario(1, "admin", true, "1234"));
        System.out.println(usuario.getNombreUsuario());
        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("inicio", messageSource.getMessage("inicio", null, locale));

        return "index";
    }

}
