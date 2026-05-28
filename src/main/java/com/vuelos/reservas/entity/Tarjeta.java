package com.vuelos.reservas.entity;

import java.io.Serializable;


public class Tarjeta extends Pago implements Serializable {

    private int idTarjeta;
    private int nroTarjeta;
    private TipoTarjeta tipoTarjeta;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Tarjeta() {}

    public Tarjeta(int idTarjeta, int nroTarjeta, TipoTarjeta tipoTarjeta,
                   int idPago, int nroPago, int cantPago) {
        super(idPago, nroPago, cantPago);
        this.idTarjeta = idTarjeta;
        this.nroTarjeta = nroTarjeta;
        this.tipoTarjeta = tipoTarjeta;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public int getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(int idTarjeta) { this.idTarjeta = idTarjeta; }

    public int getNroTarjeta() { return nroTarjeta; }
    public void setNroTarjeta(int nroTarjeta) { this.nroTarjeta = nroTarjeta; }

    public TipoTarjeta getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
}
