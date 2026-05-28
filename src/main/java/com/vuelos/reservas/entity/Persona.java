package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Persona implements Serializable {

    private int idPersona;
    protected int dniPersona;
    protected String nombrePersona;
    protected String apellidoPersona;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Persona() {}

    public Persona(int idPersona, int dniPersona, String nombrePersona, String apellidoPersona) {
        this.idPersona = idPersona;
        this.dniPersona = dniPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdPersona() { return idPersona; }
    public void setIdPersona(int idPersona) { this.idPersona = idPersona; }

    public int getDniPersona() { return dniPersona; }
    public void setDniPersona(int dniPersona) { this.dniPersona = dniPersona; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getApellidoPersona() { return apellidoPersona; }
    public void setApellidoPersona(String apellidoPersona) { this.apellidoPersona = apellidoPersona; }
}
