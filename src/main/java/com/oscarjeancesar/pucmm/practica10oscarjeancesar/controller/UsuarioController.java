package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.security.Principal;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model, Locale locale, Principal principal)
    {
        Usuario usuario = usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234"));

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("inicio", messageSource.getMessage("inicio", null, locale));


        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, Locale locale) {

        Usuario usuario = usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234"));
        model.addAttribute("tituloLogin", messageSource.getMessage("tituloLogin", null, locale));
        model.addAttribute("mensajeLogin", messageSource.getMessage("mensajeLogin", null, locale));
        model.addAttribute("placeholderUsuario", messageSource.getMessage("placeholderUsuario", null, locale));
        model.addAttribute("placerholderContrasena", messageSource.getMessage("placerholderContrasena", null, locale));
        model.addAttribute("botonEntrar", messageSource.getMessage("botonEntrar", null, locale));

        return "login";
    }

}
