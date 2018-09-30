package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.EquipoRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipoServices {
    @Autowired
    EquipoRepository equipoRepository;

    @Transactional
    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listadoEquipos() {
        return equipoRepository.findAll();
    }

    public void eliminarEquipo(long id){
        equipoRepository.delete(id);
    }

    public Equipo getEquipoPorID(long id){
        return equipoRepository.findOne(id);
    }
}
