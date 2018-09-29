package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Familia;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.FamiliaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("/familia")
public class FamiliaController {
    @Autowired
    FamiliaServices familiaServices;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
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


        model.addAttribute("placeholderNombreFamilia", messageSource.getMessage("placeholderNombreFamilia", null, locale));
        model.addAttribute("placeholderSubFamilia", messageSource.getMessage("placeholderSubFamilia", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));


        model.addAttribute("mensajeSi", messageSource.getMessage("mensajeSi", null, locale));
        model.addAttribute("mensajeNo", messageSource.getMessage("mensajeNo", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("familias", familiaServices.listadoFamilias());

        return "familias";
    }

    @RequestMapping("/crear")
    public String crearFamiliaGET(Model model, Locale locale, Principal principal) {
        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));

        model.addAttribute("linkInicio", messageSource.getMessage("linkInicio", null, locale));
        model.addAttribute("linkClientes", messageSource.getMessage("linkClientes", null, locale));
        model.addAttribute("linkEquipos", messageSource.getMessage("linkEquipos", null, locale));
        model.addAttribute("linkFamilia", messageSource.getMessage("linkFamilia", null, locale));
        model.addAttribute("linkAlquiler", messageSource.getMessage("linkAlquiler", null, locale));
        model.addAttribute("linkGraficas", messageSource.getMessage("linkGraficas", null, locale));
        model.addAttribute("linkUsuario", messageSource.getMessage("linkUsuario", null, locale));


        model.addAttribute("placeholderNombreFamilia", messageSource.getMessage("placeholderNombreFamilia", null, locale));
        model.addAttribute("placeholderSubFamilia", messageSource.getMessage("placeholderSubFamilia", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("tituloCrearFamilia", messageSource.getMessage("tituloCrearFamilia", null, locale));
        model.addAttribute("mensajeCrearFamilia", messageSource.getMessage("mensajeCrearFamilia", null, locale));


        model.addAttribute("usuario", principal.getName());

        return "agregarFamilia";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearFamiliaPOST(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "subFamilia", required = false) String subFamilia) {

        boolean esSubFamilia = subFamilia != null;

        familiaServices.crearFamilia(new Familia(nombre, esSubFamilia));

        return "redirect:/familia/";
    }
}
