package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Consulta implements Serializable {

    private int idConsulta;
    private int nroConsulta;
    private Vuelo vuelo;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Consulta() {}

    public Consulta(int idConsulta, int nroConsulta, Vuelo vuelo) {
        this.idConsulta = idConsulta;
        this.nroConsulta = nroConsulta;
        this.vuelo = vuelo;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }

    public int getNroConsulta() { return nroConsulta; }
    public void setNroConsulta(int nroConsulta) { this.nroConsulta = nroConsulta; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
}
