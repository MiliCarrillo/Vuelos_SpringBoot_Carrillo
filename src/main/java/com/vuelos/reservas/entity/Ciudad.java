package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Ciudad implements Serializable {

    private int idCiudad;
    private String nombreCiudad;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Ciudad() {}

    public Ciudad(int idCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdCiudad() { return idCiudad; }
    public void setIdCiudad(int idCiudad) { this.idCiudad = idCiudad; }

    public String getNombreCiudad() { return nombreCiudad; }
    public void setNombreCiudad(String nombreCiudad) { this.nombreCiudad = nombreCiudad; }
}
