package com.oscarjeancesar.pucmm.practica10oscarjeancesar.data;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombreUsuario);
}
