package com.Sena.PetshopAPI2.domain.dto;

public class VeterinarioDTO {

    private Integer idVeterinario;
    private String nombre;
    private String apellido;
    private String especialidad;


    // Constructor
    public VeterinarioDTO(Integer idVeterinario, String nombre, String apellido, String especialidad) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    public VeterinarioDTO() {
        
    }


    // Getters y Setters
    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }



}
