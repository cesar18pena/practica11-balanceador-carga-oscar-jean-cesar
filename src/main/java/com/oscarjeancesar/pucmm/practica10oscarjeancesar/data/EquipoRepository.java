package com.oscarjeancesar.pucmm.practica10oscarjeancesar.data;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
