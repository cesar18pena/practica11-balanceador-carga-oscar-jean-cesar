package com.oscarjeancesar.pucmm.practica10oscarjeancesar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Familia implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private boolean subFamilia;

    public Familia() {
    }

    public Familia(String nombre, boolean subFamilia) {
        this.nombre = nombre;
        this.subFamilia = subFamilia;
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

    public boolean isSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(boolean subFamilia) {
        this.subFamilia = subFamilia;
    }
}
