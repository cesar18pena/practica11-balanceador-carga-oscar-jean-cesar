package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Rol;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Locale;
import java.security.Principal;
import java.util.Set;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, Principal principal) {
        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol("ADMIN"));
        roles.add(new Rol("USER"));
        Usuario usuario = usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234", roles));

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("inicio", messageSource.getMessage("inicio", null, locale));


        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model, Locale locale) {

        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol("ADMIN"));
        roles.add(new Rol("USER"));

        Usuario usuario = usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234", roles));

        model.addAttribute("tituloLogin", messageSource.getMessage("tituloLogin", null, locale));
        model.addAttribute("mensajeLogin", messageSource.getMessage("mensajeLogin", null, locale));
        model.addAttribute("placeholderUsuario", messageSource.getMessage("placeholderUsuario", null, locale));
        model.addAttribute("placerholderContrasena", messageSource.getMessage("placerholderContrasena", null, locale));
        model.addAttribute("botonEntrar", messageSource.getMessage("botonEntrar", null, locale));

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(Model model, @ModelAttribute("Usuario") Usuario usuario, Locale locale) {

        usuarioServices.autoLogin(usuario.getUsername(), usuario.getPassword());

        return "redirect:/";
    }


}
