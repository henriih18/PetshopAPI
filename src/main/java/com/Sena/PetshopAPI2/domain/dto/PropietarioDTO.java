package com.Sena.PetshopAPI2.domain.dto;

import java.util.List;

public class PropietarioDTO {
    private Integer idPropietario;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String direccion;
    private String telefono;
    private List<MascotaDTO> mascotas; // Relación con MascotaDTO

    // Getters y Setters
    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }
}
