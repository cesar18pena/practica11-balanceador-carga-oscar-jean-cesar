package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.AlquilerRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Alquiler;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AlquilerServices {
    @Autowired
    AlquilerRepository alquilerRepository;

    @Transactional
    public Alquiler crearAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    public List<Alquiler> listadoAlquiler() {
        return alquilerRepository.findAll();
    }

    public List<Alquiler> listadoAlquilerOrdenado() {
        return alquilerRepository.alquileresOrdenados();
    }

    public Alquiler getAlquilerPorID(long id){
        return alquilerRepository.findOne(id);
    }

    public List<Alquiler> historialAlquiler(Cliente cliente) {
        return alquilerRepository.findAllByClienteOrderByFechaDesc(cliente);
    }
}
