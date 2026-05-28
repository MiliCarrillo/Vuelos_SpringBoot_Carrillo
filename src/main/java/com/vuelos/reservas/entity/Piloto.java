package com.vuelos.reservas.entity;


public class Piloto extends Persona {

    private int nroPiloto;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Piloto() {}

    public Piloto(int nroPiloto, int idPersona, int dniPersona,
                  String nombrePersona, String apellidoPersona) {
        super(idPersona, dniPersona, nombrePersona, apellidoPersona);
        this.nroPiloto = nroPiloto;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getNroPiloto() { return nroPiloto; }
    public void setNroPiloto(int nroPiloto) { this.nroPiloto = nroPiloto; }
}
