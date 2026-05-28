package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Tarifa implements Serializable {

    private int idTarifa;
    private int nroTarifa;
    private int impuestoTarifa;
    private int precioTarifa;
    private Clase claseTarifa;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Tarifa() {}

    public Tarifa(int idTarifa, int nroTarifa, int impuestoTarifa,
                  int precioTarifa, Clase claseTarifa) {
        this.idTarifa = idTarifa;
        this.nroTarifa = nroTarifa;
        this.impuestoTarifa = impuestoTarifa;
        this.precioTarifa = precioTarifa;
        this.claseTarifa = claseTarifa;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdTarifa() { return idTarifa; }
    public void setIdTarifa(int idTarifa) { this.idTarifa = idTarifa; }

    public int getNroTarifa() { return nroTarifa; }
    public void setNroTarifa(int nroTarifa) { this.nroTarifa = nroTarifa; }

    public int getImpuestoTarifa() { return impuestoTarifa; }
    public void setImpuestoTarifa(int impuestoTarifa) { this.impuestoTarifa = impuestoTarifa; }

    public int getPrecioTarifa() { return precioTarifa; }
    public void setPrecioTarifa(int precioTarifa) { this.precioTarifa = precioTarifa; }

    public Clase getClaseTarifa() { return claseTarifa; }
    public void setClaseTarifa(Clase claseTarifa) { this.claseTarifa = claseTarifa; }
}
