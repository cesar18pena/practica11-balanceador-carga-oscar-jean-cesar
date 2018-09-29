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
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));

        model.addAttribute("linkInicio", messageSource.getMessage("linkInicio", null, locale));
        model.addAttribute("linkClientes", messageSource.getMessage("linkClientes", null, locale));
        model.addAttribute("linkEquipos", messageSource.getMessage("linkEquipos", null, locale));
        model.addAttribute("linkFamilia", messageSource.getMessage("linkFamilia", null, locale));
        model.addAttribute("linkAlquiler", messageSource.getMessage("linkAlquiler", null, locale));
        model.addAttribute("linkGraficas", messageSource.getMessage("linkGraficas", null, locale));
        model.addAttribute("linkUsuario", messageSource.getMessage("linkUsuario", null, locale));

        model.addAttribute("usuario", principal.getName());

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Model model, Locale locale) {
        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol("ADMIN"));
        roles.add(new Rol("USER"));

        usuarioServices.crearUsuario(new Usuario(1, "admin", true, "1234", roles));

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("tituloLogin", messageSource.getMessage("tituloLogin", null, locale));
        model.addAttribute("mensajeLogin", messageSource.getMessage("mensajeLogin", null, locale));
        model.addAttribute("placeholderUsuario", messageSource.getMessage("placeholderUsuario", null, locale));
        model.addAttribute("placerholderContrasena", messageSource.getMessage("placerholderContrasena", null, locale));
        model.addAttribute("botonEntrar", messageSource.getMessage("botonEntrar", null, locale));

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password
    ) {
        usuarioServices.autoLogin(username, password);

        return "redirect:/";
    }

    @RequestMapping(value = "/crear-usuario", method = RequestMethod.GET)
    public String crearUsuarioGET(Model model, Locale locale) {

        model.addAttribute("linkInicio", messageSource.getMessage("linkInicio", null, locale));
        model.addAttribute("linkClientes", messageSource.getMessage("linkClientes", null, locale));
        model.addAttribute("linkEquipos", messageSource.getMessage("linkEquipos", null, locale));
        model.addAttribute("linkFamilia", messageSource.getMessage("linkFamilia", null, locale));
        model.addAttribute("linkAlquiler", messageSource.getMessage("linkAlquiler", null, locale));
        model.addAttribute("linkGraficas", messageSource.getMessage("linkGraficas", null, locale));
        model.addAttribute("linkUsuario", messageSource.getMessage("linkUsuario", null, locale));

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("esAdmin", messageSource.getMessage("esAdmin", null, locale));
        model.addAttribute("placeholderUsuario", messageSource.getMessage("placeholderUsuario", null, locale));
        model.addAttribute("placerholderContrasena", messageSource.getMessage("placerholderContrasena", null, locale));

        model.addAttribute("tituloCrearUsuario", messageSource.getMessage("tituloCrearUsuario", null, locale));
        model.addAttribute("mensajeCrearUsuario", messageSource.getMessage("mensajeCrearUsuario", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        return "crearUsuario";
    }

    @RequestMapping(value = "/crear-usuario", method = RequestMethod.POST)
    public String crearUsuarioPOST(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "esAdmin", required = false) String esAdmin

    ) {
        boolean admin = esAdmin != null;
        Set<Rol> roles = new HashSet<>();
        roles.add(new Rol("USER"));

        if (admin){
            roles.add(new Rol("ADMIN"));
        }

        long idCount = usuarioServices.getIDCount();
        usuarioServices.crearUsuario(new Usuario(idCount, username, admin, password, roles ));

        return "redirect:/";
    }



}
