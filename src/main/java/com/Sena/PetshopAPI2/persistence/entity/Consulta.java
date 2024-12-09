package com.Sena.PetshopAPI2.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idConsulta;

    @ManyToOne
    @JoinColumn(name = "idMascota", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "idVeterinario", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Veterinario veterinario;

    private LocalDate fecha;
    private String descripcion;

    // Getters y Setters

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
