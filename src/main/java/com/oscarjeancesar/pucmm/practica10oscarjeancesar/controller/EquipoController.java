package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Equipo;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Familia;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.EquipoServices;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.FamiliaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
    @Autowired
    EquipoServices equipoServices;

    @Autowired
    FamiliaServices familiaServices;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model, Locale locale, Principal principal) {

        boolean sizeFamilia = familiaServices.listadoFamilias().size() > 0;
        model.addAttribute("sizeFamilia", sizeFamilia);

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));

        model.addAttribute("linkInicio", messageSource.getMessage("linkInicio", null, locale));
        model.addAttribute("linkClientes", messageSource.getMessage("linkClientes", null, locale));
        model.addAttribute("linkEquipos", messageSource.getMessage("linkEquipos", null, locale));
        model.addAttribute("linkFamilia", messageSource.getMessage("linkFamilia", null, locale));
        model.addAttribute("linkAlquiler", messageSource.getMessage("linkAlquiler", null, locale));
        model.addAttribute("linkGraficas", messageSource.getMessage("linkGraficas", null, locale));
        model.addAttribute("linkUsuario", messageSource.getMessage("linkUsuario", null, locale));

        model.addAttribute("tituloCrearEquipo", messageSource.getMessage("tituloCrearEquipo", null, locale));
        model.addAttribute("mensajeCrearEquipo", messageSource.getMessage("mensajeCrearEquipo", null, locale));
        model.addAttribute("placeholderNombreEquipo", messageSource.getMessage("placeholderNombreEquipo", null, locale));
        model.addAttribute("placeholderFamiliaEquipo", messageSource.getMessage("placeholderFamiliaEquipo", null, locale));
        model.addAttribute("placeholderSubFamiliaEquipo", messageSource.getMessage("placeholderSubFamiliaEquipo", null, locale));
        model.addAttribute("placeholderExistencia", messageSource.getMessage("placeholderExistencia", null, locale));
        model.addAttribute("placeholderCostoPorDia", messageSource.getMessage("placeholderCostoPorDia", null, locale));
        model.addAttribute("placeholderImagen", messageSource.getMessage("placeholderImagen", null, locale));

        model.addAttribute("mensajeNoFamilias", messageSource.getMessage("mensajeNoFamilias", null, locale));

        model.addAttribute("acciones", messageSource.getMessage("acciones", null, locale));
        model.addAttribute("acciones2", messageSource.getMessage("acciones2", null, locale));

        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("equipos", equipoServices.listadoEquipos());

        return "equipos";
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

        model.addAttribute("tituloCrearEquipo", messageSource.getMessage("tituloCrearEquipo", null, locale));
        model.addAttribute("mensajeCrearEquipo", messageSource.getMessage("mensajeCrearEquipo", null, locale));
        model.addAttribute("placeholderNombreEquipo", messageSource.getMessage("placeholderNombreEquipo", null, locale));
        model.addAttribute("placeholderFamiliaEquipo", messageSource.getMessage("placeholderFamiliaEquipo", null, locale));
        model.addAttribute("placeholderSubFamiliaEquipo", messageSource.getMessage("placeholderSubFamiliaEquipo", null, locale));
        model.addAttribute("placeholderExistencia", messageSource.getMessage("placeholderExistencia", null, locale));
        model.addAttribute("placeholderCostoPorDia", messageSource.getMessage("placeholderCostoPorDia", null, locale));
        model.addAttribute("placeholderImagen", messageSource.getMessage("placeholderImagen", null, locale));

        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("familias", familiaServices.listadoFamilias());

        return "agregarEquipo";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearEquipoPOST(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "familia", required = false) long familia,
            @RequestParam(value = "subFamilia", required = false) long subFamilia,
            @RequestParam(value = "existencia", required = false) long existencia,
            @RequestParam(value = "costoPorDia", required = false) long costoPorDia,
            @RequestParam(value = "imagen", required = false) String imagen) {
        Familia familiaObject = null;
        Familia subFamiliaObject = null;

        if(familia != 0){
           familiaObject = familiaServices.buscarPorId(familia);
        }
        if(subFamilia != 0){
            subFamiliaObject = familiaServices.buscarPorId(subFamilia);
        }

        equipoServices.crearEquipo(new Equipo(nombre, familiaObject, subFamiliaObject, existencia, costoPorDia, imagen));

        return "redirect:/equipo/";
    }

    @RequestMapping(value = "/eliminar-familia/{id}", method = RequestMethod.POST)
    public String crearClientePOST(@PathVariable("id") long id){

        familiaServices.eliminarFamilia(id);

        return "redirect:/familia/";
    }

    @RequestMapping(value = "/eliminar-equipo/{id}", method = RequestMethod.POST)
    public String eliminarEquipoPOST(@PathVariable("id") long id){

        equipoServices.eliminarEquipo(id);

        return "redirect:/equipo/";
    }

    @RequestMapping(value = "/modificar-equipo/{id}")
    public String modificarEquipoGET(Model model, Locale locale, Principal principal, @PathVariable("id") long idEquipo) {

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));

        model.addAttribute("linkInicio", messageSource.getMessage("linkInicio", null, locale));
        model.addAttribute("linkClientes", messageSource.getMessage("linkClientes", null, locale));
        model.addAttribute("linkEquipos", messageSource.getMessage("linkEquipos", null, locale));
        model.addAttribute("linkFamilia", messageSource.getMessage("linkFamilia", null, locale));
        model.addAttribute("linkAlquiler", messageSource.getMessage("linkAlquiler", null, locale));
        model.addAttribute("linkGraficas", messageSource.getMessage("linkGraficas", null, locale));
        model.addAttribute("linkUsuario", messageSource.getMessage("linkUsuario", null, locale));

        model.addAttribute("tituloCrearEquipo", messageSource.getMessage("tituloCrearEquipo", null, locale));
        model.addAttribute("mensajeCrearEquipo", messageSource.getMessage("mensajeCrearEquipo", null, locale));
        model.addAttribute("placeholderNombreEquipo", messageSource.getMessage("placeholderNombreEquipo", null, locale));
        model.addAttribute("placeholderFamiliaEquipo", messageSource.getMessage("placeholderFamiliaEquipo", null, locale));
        model.addAttribute("placeholderSubFamiliaEquipo", messageSource.getMessage("placeholderSubFamiliaEquipo", null, locale));
        model.addAttribute("placeholderExistencia", messageSource.getMessage("placeholderExistencia", null, locale));
        model.addAttribute("placeholderCostoPorDia", messageSource.getMessage("placeholderCostoPorDia", null, locale));
        model.addAttribute("placeholderImagen", messageSource.getMessage("placeholderImagen", null, locale));

        model.addAttribute("acciones", messageSource.getMessage("acciones", null, locale));

        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("equipos", equipoServices.listadoEquipos());

        model.addAttribute("tituloModificarEquipo", messageSource.getMessage("tituloModificarEquipo", null, locale));
        model.addAttribute("mensajeModificarEquipo", messageSource.getMessage("mensajeModificarEquipo", null, locale));

        model.addAttribute("familias", familiaServices.listadoFamilias());
        model.addAttribute("acciones2", messageSource.getMessage("acciones2", null, locale));


        // Parámetros del equipo
        Equipo equipoAModificar = equipoServices.getEquipoPorID(idEquipo);
        model.addAttribute("equipo", equipoAModificar);

        return "modificarEquipos";
    }

    @RequestMapping(value = "/modificar/{id}", method = RequestMethod.POST)
    public String modificarEquipoPOST(@PathVariable("id") long id,
      @RequestParam(value = "nombre", required = false) String nombre,
      @RequestParam(value = "familia", required = false) long familia,
      @RequestParam(value = "subFamilia", required = false) long subFamilia,
      @RequestParam(value = "existencia", required = false) long existencia,
      @RequestParam(value = "costoPorDia", required = false) long costoPorDia,
      @RequestParam(value = "imagen", required = false) String imagen){

        Familia familiaObject = familiaServices.buscarPorId(familia);
        Familia subFamiliaObject = familiaServices.buscarPorId(subFamilia);

        Equipo equipo = equipoServices.getEquipoPorID(id);
        equipo.setNombre(nombre);
        equipo.setFamilia(familiaObject);
        equipo.setSubFamilia(subFamiliaObject);
        equipo.setExistencia(existencia);
        equipo.setCostoPorDia(costoPorDia);
        equipo.setImagen(imagen);
        equipoServices.crearEquipo(equipo);

        return "redirect:/equipo/";
    }
}
