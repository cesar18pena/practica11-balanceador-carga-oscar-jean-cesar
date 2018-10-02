package com.oscarjeancesar.pucmm.practica10oscarjeancesar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Familia familia;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Familia subFamilia;

    private long existencia;
    private long costoPorDia;
    private String imagen;

    public Equipo() {
    }

    public Equipo(String nombre, Familia familia, Familia subFamilia, long existencia, long costoPorDia, String imagen) {
        this.nombre = nombre;
        this.familia = familia;
        this.subFamilia = subFamilia;
        this.existencia = existencia;
        this.costoPorDia = costoPorDia;
        this.imagen = imagen;
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

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Familia getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(Familia subFamilia) {
        this.subFamilia = subFamilia;
    }

    public long getExistencia() {
        return existencia;
    }

    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }

    public long getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(long costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
