package com.prestigelogic.solutions.gimnacioapi.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_miembro")
    private Miembro miembro;

    private Date fechaInicio;
    private Date fechaFin;
    private String tipoSuscripcion;
    private Double precio;

    // Getters y Setters


    public Suscripcion() {
    }

    public Suscripcion(Long id, Miembro miembro, Date fechaInicio, Date fechaFin, String tipoSuscripcion, Double precio) {
        this.id = id;
        this.miembro = miembro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoSuscripcion = tipoSuscripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
