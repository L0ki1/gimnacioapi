package com.prestigelogic.solutions.gimnacioapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_miembro")
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "id_suscripcion")
    private Suscripcion suscripcion;

    private Date fechaPago;
    private Double monto;
    private String metodoPago;

    // Getters y Setters

    public Pago() {
    }

    public Pago(Long id, Miembro miembro, Suscripcion suscripcion, Date fechaPago, Double monto, String metodoPago) {
        this.id = id;
        this.miembro = miembro;
        this.suscripcion = suscripcion;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
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

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
