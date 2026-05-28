package com.vuelos.reservas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int nroVuelo;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String destino;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String piloto;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String aerolinea;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String aeropuerto;

    @Column(nullable = false)
    private int nroAvion;

    // ── Constructores ─────────────────────────────────────────────────────────

    public Vuelo() {}

    public Vuelo(int nroVuelo, String destino, String piloto, LocalDate fecha,
                 String aerolinea, String aeropuerto, int nroAvion) {
        this.nroVuelo = nroVuelo;
        this.destino = destino;
        this.piloto = piloto;
        this.fecha = fecha;
        this.aerolinea = aerolinea;
        this.aeropuerto = aeropuerto;
        this.nroAvion = nroAvion;
    }

    // ── Getters y Setters ─────────────────────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNroVuelo() { return nroVuelo; }
    public void setNroVuelo(int nroVuelo) { this.nroVuelo = nroVuelo; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getPiloto() { return piloto; }
    public void setPiloto(String piloto) { this.piloto = piloto; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getAerolinea() { return aerolinea; }
    public void setAerolinea(String aerolinea) { this.aerolinea = aerolinea; }

    public String getAeropuerto() { return aeropuerto; }
    public void setAeropuerto(String aeropuerto) { this.aeropuerto = aeropuerto; }

    public int getNroAvion() { return nroAvion; }
    public void setNroAvion(int nroAvion) { this.nroAvion = nroAvion; }
}
