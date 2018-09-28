package com.oscarjeancesar.pucmm.practica10oscarjeancesar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String cedula;
    private String telefono;
    private String fotografia;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String telefono, String fotografia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fotografia = fotografia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
}
