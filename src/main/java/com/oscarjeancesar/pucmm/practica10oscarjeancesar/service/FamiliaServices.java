package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.FamiliaRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamiliaServices {
    @Autowired
    FamiliaRepository familiaRepository;

    @Transactional
    public Familia crearFamilia(Familia familia) {
        return familiaRepository.save(familia);
    }

    public List<Familia> listadoFamilias() {
        return familiaRepository.findAll();
    }

    public Familia buscarPorId(long id) {
        return familiaRepository.findById(id);
    }
}
