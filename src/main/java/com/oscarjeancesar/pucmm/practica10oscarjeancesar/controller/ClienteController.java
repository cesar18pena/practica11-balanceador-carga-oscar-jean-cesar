package com.oscarjeancesar.pucmm.practica10oscarjeancesar.controller;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.*;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteServices clienteServices;

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    StorageService storageService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    UsuarioServices usuarioServices;

    private static String UPLOADED_FOLDER = new File("src/main/resources/static/img").getAbsolutePath();

    @RequestMapping(value = "/subir-foto/{id}", method = RequestMethod.POST)
    public String crearFotoPOST(@PathVariable("id") long id, @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            System.out.println(bytes);
            Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
            Files.write(path, bytes);

            Cliente cliente = clienteServices.getClientePorID(id);
            cliente.setFotografia(file.getOriginalFilename());

            clienteServices.crearCliente(cliente);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/cliente/";
    }

    @RequestMapping(value = "/")
    public String index(Model model, Locale locale, Principal principal) {
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

        model.addAttribute("placeholderNombreCliente", messageSource.getMessage("placeholderNombreCliente", null, locale));
        model.addAttribute("placeholderCedula", messageSource.getMessage("placeholderCedula", null, locale));
        model.addAttribute("placerholderTelefono", messageSource.getMessage("placerholderTelefono", null, locale));
        model.addAttribute("placerholderFotografia", messageSource.getMessage("placerholderFotografia", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("mensajeNoClientes", messageSource.getMessage("mensajeNoClientes", null, locale));

        model.addAttribute("usuario", principal.getName());
        model.addAttribute("acciones", messageSource.getMessage("acciones", null, locale));
        model.addAttribute("acciones2", messageSource.getMessage("acciones2", null, locale));
        model.addAttribute("ver", messageSource.getMessage("ver", null, locale));

        model.addAttribute("clientes", clienteServices.getListadoDeClientes());

        model.addAttribute("subirFoto", messageSource.getMessage("subirFoto", null, locale));

        model.addAttribute("esAdmin", usuarioServices.buscarPorNombre(principal.getName()).isEsAdmin());

        return "clientes";
    }

    @RequestMapping(value = "/crear")
    public String crearClienteGET(Model model, Locale locale, Principal principal) {
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

        model.addAttribute("placeholderNombreCliente", messageSource.getMessage("placeholderNombreCliente", null, locale));
        model.addAttribute("placeholderCedula", messageSource.getMessage("placeholderCedula", null, locale));
        model.addAttribute("placerholderTelefono", messageSource.getMessage("placerholderTelefono", null, locale));
        model.addAttribute("placerholderFotografia", messageSource.getMessage("placerholderFotografia", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("tituloCrearCliente", messageSource.getMessage("tituloCrearCliente", null, locale));
        model.addAttribute("mensajeCrearCliente", messageSource.getMessage("mensajeCrearCliente", null, locale));

        model.addAttribute("usuario", principal.getName());

        return "agregarCliente";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearClientePOST(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "cedula", required = false) String cedula,
            @RequestParam(value = "telefono", required = false) String telefono) {

        clienteServices.crearCliente(new Cliente(nombre, cedula, telefono, ""));

        return "redirect:/cliente/";
    }

    @RequestMapping(value = "/eliminar-cliente/{id}", method = RequestMethod.POST)
    public String eliminarClientePOST(@PathVariable("id") long id) {
        clienteServices.eliminarCliente(id);

        return "redirect:/cliente/";
    }

    @RequestMapping(value = "/modificar-cliente/{id}")
    public String modificarClienteGET(Model model, Locale locale, Principal principal, @PathVariable("id") long idCliente) {
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

        model.addAttribute("placeholderNombreCliente", messageSource.getMessage("placeholderNombreCliente", null, locale));
        model.addAttribute("placeholderCedula", messageSource.getMessage("placeholderCedula", null, locale));
        model.addAttribute("placerholderTelefono", messageSource.getMessage("placerholderTelefono", null, locale));
        model.addAttribute("placerholderFotografia", messageSource.getMessage("placerholderFotografia", null, locale));
        model.addAttribute("botonCrear", messageSource.getMessage("botonCrear", null, locale));

        model.addAttribute("acciones2", messageSource.getMessage("acciones2", null, locale));
        model.addAttribute("tituloModificarCliente", messageSource.getMessage("tituloModificarCliente", null, locale));
        model.addAttribute("mensajeModificarCliente", messageSource.getMessage("mensajeModificarCliente", null, locale));

        model.addAttribute("usuario", principal.getName());

        // Parámetros del cliente
        Cliente clienteAModificar = clienteServices.getClientePorID(idCliente);
        model.addAttribute("cliente", clienteAModificar);

        return "modificarCliente";
    }

    @RequestMapping(value = "/modificar/{id}", method = RequestMethod.POST)
    public String modificarClientePOST(@PathVariable("id") long id,
                                       @RequestParam(value = "nombre", required = false) String nombre,
                                       @RequestParam(value = "cedula", required = false) String cedula,
                                       @RequestParam(value = "telefono", required = false) String telefono) {

        Cliente cliente = clienteServices.getClientePorID(id);
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setTelefono(telefono);
        cliente.setFotografia(cliente.getFotografia());
        clienteServices.crearCliente(cliente);

        return "redirect:/cliente/";
    }

    @RequestMapping("/ver/{id}")
    public String verClienteGET(Model model, Locale locale, Principal principal, @PathVariable("id") long id) {
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

        model.addAttribute("fechaCreacion", messageSource.getMessage("fechaCreacion", null, locale));
        model.addAttribute("fechaEntrega", messageSource.getMessage("fechaEntrega", null, locale));
        model.addAttribute("clienteMensaje", messageSource.getMessage("clienteMensaje", null, locale));
        model.addAttribute("total", messageSource.getMessage("total", null, locale));
        model.addAttribute("ver", messageSource.getMessage("ver", null, locale));

        model.addAttribute("placeholderNombreCliente", messageSource.getMessage("placeholderNombreCliente", null, locale));
        model.addAttribute("placeholderCedula", messageSource.getMessage("placeholderCedula", null, locale));
        model.addAttribute("placerholderTelefono", messageSource.getMessage("placerholderTelefono", null, locale));
        model.addAttribute("placerholderFotografia", messageSource.getMessage("placerholderFotografia", null, locale));

        model.addAttribute("usuario", principal.getName());

        model.addAttribute("datosDelCliente", messageSource.getMessage("datosDelCliente", null, locale));
        model.addAttribute("equiposDelCliente", messageSource.getMessage("equiposDelCliente", null, locale));

        Cliente cliente = clienteServices.getClientePorID(id);

        model.addAttribute("cliente", cliente);

        model.addAttribute("alquileres", alquilerServices.historialAlquiler(cliente));

        return "verCliente";
    }
}
