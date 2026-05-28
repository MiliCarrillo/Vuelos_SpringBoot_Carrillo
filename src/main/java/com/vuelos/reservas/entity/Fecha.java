package com.vuelos.reservas.entity;

import java.io.Serializable;
import java.util.Date;


public class Fecha implements Serializable {

    private int idFecha;
    private Date fecha;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Fecha() {}

    public Fecha(int idFecha, Date fecha) {
        this.idFecha = idFecha;
        this.fecha = fecha;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdFecha() { return idFecha; }
    public void setIdFecha(int idFecha) { this.idFecha = idFecha; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}
