package com.vuelos.reservas.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Avion implements Especificacion, Serializable {

    private int idAvion;
    private int nroAvion;
    private ArrayList<Asiento> asientos = new ArrayList<>();

    // ── Constructores ─────────────────────────────────────────────────────────

    public Avion() {}

    public Avion(int idAvion, int nroAvion) {
        this.idAvion = idAvion;
        this.nroAvion = nroAvion;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdAvion() { return idAvion; }
    public void setIdAvion(int idAvion) { this.idAvion = idAvion; }

    public int getNroAvion() { return nroAvion; }
    public void setNroAvion(int nroAvion) { this.nroAvion = nroAvion; }

    public ArrayList<Asiento> getAsientos() { return asientos; }

    public void addAsientos(Asiento asiento) { this.asientos.add(asiento); }
    public void removeAsientos(Asiento asiento) { this.asientos.remove(asiento); }

    // ── Especificacion ────────────────────────────────────────────────────────

    @Override
    public String tipoTurbina() { return "2"; }

    @Override
    public String tipoAvion() { return "avioneta"; }
}
