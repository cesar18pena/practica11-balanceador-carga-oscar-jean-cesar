package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.data.ClienteRepository;
import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> getListadoDeClientes() {
        return clienteRepository.findAll();
    }
}
