package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Aeropuerto implements Serializable {

    private int idAeropuerto;
    private String nombreAeropuerto;
    private Ciudad ciudad;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Aeropuerto() {}

    public Aeropuerto(int idAeropuerto, String nombreAeropuerto, Ciudad ciudad) {
        this.idAeropuerto = idAeropuerto;
        this.nombreAeropuerto = nombreAeropuerto;
        this.ciudad = ciudad;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdAeropuerto() { return idAeropuerto; }
    public void setIdAeropuerto(int idAeropuerto) { this.idAeropuerto = idAeropuerto; }

    public String getNombreAeropuerto() { return nombreAeropuerto; }
    public void setNombreAeropuerto(String nombreAeropuerto) { this.nombreAeropuerto = nombreAeropuerto; }

    public Ciudad getCiudad() { return ciudad; }
    public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
}
