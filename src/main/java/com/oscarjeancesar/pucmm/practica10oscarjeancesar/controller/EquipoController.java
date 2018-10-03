package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Alquiler;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Equipo;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Familia;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.AlquilerServices;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.EquipoServices;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.FamiliaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
    @Autowired
    EquipoServices equipoServices;

    @Autowired
    FamiliaServices familiaServices;

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    private MessageSource messageSource;
    private static String UPLOADED_FOLDER = new File("src/main/resources/static/img").getAbsolutePath();

    @RequestMapping("/")
    public String index(Model model, Locale locale, Principal principal) {
        boolean sizeFamilia = familiaServices.listadoFamilias().size() > 0;
        model.addAttribute("sizeFamilia", sizeFamilia);

        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("creador", messageSource.getMessage("creador", null, locale));

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
        model.addAttribute("mensajeNoEquipos", messageSource.getMessage("mensajeNoEquipos", null, locale));

        model.addAttribute("acciones", messageSource.getMessage("acciones", null, locale));
        model.addAttribute("acciones2", messageSource.getMessage("acciones2", null, locale));

        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("equipos", equipoServices.listadoEquipos());

        model.addAttribute("subirFoto", messageSource.getMessage("subirFoto", null, locale));

        return "equipos";
    }

    @RequestMapping("/crear")
    public String crearFamiliaGET(Model model, Locale locale, Principal principal) {
        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("creador", messageSource.getMessage("creador", null, locale));

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
            @RequestParam(value = "familia", required = false) Long familia,
            @RequestParam(value = "subFamilia", required = false) Long subFamilia,
            @RequestParam(value = "existencia", required = false) Long existencia,
            @RequestParam(value = "costoPorDia", required = false) Long costoPorDia)
    {
        Familia familiaObject = null;
        Familia subFamiliaObject = null;

        familiaObject = familiaServices.buscarPorId(familia);
        subFamiliaObject = familiaServices.buscarPorId(subFamilia);

        equipoServices.crearEquipo(new Equipo(nombre, familiaObject, subFamiliaObject, existencia, costoPorDia, ""));

        return "redirect:/equipo/";
    }

    @RequestMapping(value = "/subir-foto/{id}", method = RequestMethod.POST)
    public String crearFotoPOST(@PathVariable("id") long id, @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            System.out.println(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
            Files.write(path, bytes);

            Equipo equipo = equipoServices.getEquipoPorID(id);
            equipo.setImagen(file.getOriginalFilename());

            equipoServices.crearEquipo(equipo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/equipo/";
    }


    @RequestMapping(value = "/eliminar-familia/{id}", method = RequestMethod.POST)
    public String crearClientePOST(@PathVariable("id") long id ) {

        familiaServices.eliminarFamilia(id);

        return "redirect:/familia/";
    }

    @RequestMapping(value = "/eliminar-equipo/{id}", method = RequestMethod.POST)
    public String eliminarEquipoPOST(@PathVariable("id") long id) {

        equipoServices.eliminarEquipo(id);

        return "redirect:/equipo/";
    }

    @RequestMapping(value = "/modificar-equipo/{id}")
    public String modificarEquipoGET(Model model, Locale locale, Principal principal, @PathVariable("id") long idEquipo) {
        model.addAttribute("titulo", messageSource.getMessage("titulo", null, locale));
        model.addAttribute("mensaje", messageSource.getMessage("mensaje", null, locale));
        model.addAttribute("creador", messageSource.getMessage("creador", null, locale));

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
                                      @RequestParam(value = "costoPorDia", required = false) long costoPorDia) {
        Familia familiaObject = familiaServices.buscarPorId(familia);
        Familia subFamiliaObject = familiaServices.buscarPorId(subFamilia);

        Equipo equipo = equipoServices.getEquipoPorID(id);
        equipo.setNombre(nombre);
        equipo.setFamilia(familiaObject);
        equipo.setSubFamilia(subFamiliaObject);
        equipo.setExistencia(existencia);
        equipo.setCostoPorDia(costoPorDia);
        equipo.setImagen(equipo.getImagen());
        equipoServices.crearEquipo(equipo);

        return "redirect:/equipo/";
    }

    @RequestMapping(value = "/devolver/{id}/{alquilerId}", method = RequestMethod.POST)
    public String devolverEquipoPOST(@PathVariable("id") long id, @PathVariable("alquilerId") long alquilerId) {
        Equipo equipo = equipoServices.getEquipoPorID(id);
        Alquiler alquiler = alquilerServices.getAlquilerPorID(alquilerId);

        equipo.setExistencia(equipo.getExistencia() + 1);

        equipoServices.crearEquipo(equipo);

        long resta = new Date().getTime() - alquiler.getFecha().getTime();
        long diff = TimeUnit.DAYS.convert(resta, TimeUnit.MILLISECONDS);

        Familia familia = equipo.getFamilia();
        Familia subfamilia = equipo.getSubFamilia();

        familia.getDiasAlquilados().add(diff);
        subfamilia.getDiasAlquilados().add(diff);

        familiaServices.crearFamilia(familia);
        familiaServices.crearFamilia(subfamilia);

        alquiler.setTotal(alquiler.getTotal() + (diff * equipo.getCostoPorDia()));

        alquiler.getEquipos().remove(equipo);

        alquilerServices.crearAlquiler(alquiler);

        return "redirect:/alquiler/ver/" + alquilerId;
    }
}
