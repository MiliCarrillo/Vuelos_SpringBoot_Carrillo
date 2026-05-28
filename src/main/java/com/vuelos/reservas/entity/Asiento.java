package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Asiento implements Serializable {

    private int idAsiento;
    private int filaAsiento;
    private char letraAsiento;
    private Clase clasAsiento;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Asiento() {}

    public Asiento(int idAsiento, int filaAsiento, char letraAsiento, Clase clasAsiento) {
        this.idAsiento = idAsiento;
        this.filaAsiento = filaAsiento;
        this.letraAsiento = letraAsiento;
        this.clasAsiento = clasAsiento;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }

    public int getFilaAsiento() { return filaAsiento; }
    public void setFilaAsiento(int filaAsiento) { this.filaAsiento = filaAsiento; }

    public char getLetraAsiento() { return letraAsiento; }
    public void setLetraAsiento(char letraAsiento) { this.letraAsiento = letraAsiento; }

    public Clase getClasAsiento() { return clasAsiento; }
    public void setClasAsiento(Clase clasAsiento) { this.clasAsiento = clasAsiento; }
}
