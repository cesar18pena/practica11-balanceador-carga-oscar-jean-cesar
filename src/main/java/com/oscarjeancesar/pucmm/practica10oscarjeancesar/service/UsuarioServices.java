package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.UsuarioRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }
}
