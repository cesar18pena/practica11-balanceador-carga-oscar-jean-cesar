package com.oscarjeancesar.pucmm.practica10oscarjeancesar.data;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Alquiler;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
    List<Alquiler> findAllByClienteOrderByFechaDesc(Cliente cliente);

    @Query("SELECT alquiler FROM Alquiler alquiler ORDER BY alquiler.fecha")
    List<Alquiler> alquileresOrdenados();
}
