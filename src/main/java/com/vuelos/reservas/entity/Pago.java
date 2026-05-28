package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Pago implements Serializable {

    private int idPago;
    protected int nroPago;
    protected int cantPago;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Pago() {}

    public Pago(int idPago, int nroPago, int cantPago) {
        this.idPago = idPago;
        this.nroPago = nroPago;
        this.cantPago = cantPago;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public int getNroPago() { return nroPago; }
    public void setNroPago(int nroPago) { this.nroPago = nroPago; }

    public int getCantPago() { return cantPago; }
    public void setCantPago(int cantPago) { this.cantPago = cantPago; }
}
