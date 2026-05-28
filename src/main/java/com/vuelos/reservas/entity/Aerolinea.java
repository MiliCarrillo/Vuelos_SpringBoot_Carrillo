package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Aerolinea implements Serializable {

    private int idAerolinea;
    private String nombreAerolinea;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Aerolinea() {}

    public Aerolinea(int idAerolinea, String nombreAerolinea) {
        this.idAerolinea = idAerolinea;
        this.nombreAerolinea = nombreAerolinea;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdAerolinea() { return idAerolinea; }
    public void setIdAerolinea(int idAerolinea) { this.idAerolinea = idAerolinea; }

    public String getNombreAerolinea() { return nombreAerolinea; }
    public void setNombreAerolinea(String nombreAerolinea) { this.nombreAerolinea = nombreAerolinea; }
}
