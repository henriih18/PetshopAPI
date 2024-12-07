package com.Sena.PetshopAPI2.web.controller;


import com.Sena.PetshopAPI2.domain.dto.ConsultaDTO;

import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import com.Sena.PetshopAPI2.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Obtener todas las consultas
    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    // Obtener consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable int id) {
        Optional<Consulta> consulta = consultaService.getConsultaById(id);
        return consulta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todas las consultas de una mascota por su ID
    @GetMapping("/mascota/{mascotaId}")
    public List<Consulta> getConsultasByMascotaId(@PathVariable int mascotaId) {
        return consultaService.getConsultasByMascotaId(mascotaId);
    }

    // Obtener todas las consultas de un veterinario por su ID
    @GetMapping("/veterinario/{veterinarioId}")
    public List<Consulta> getConsultasByVeterinarioId(@PathVariable int veterinarioId) {
        return consultaService.getConsultasByVeterinarioId(veterinarioId);
    }

    // Crear una nueva consulta
    @PostMapping
    public Consulta createConsulta(@RequestBody ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta();
        consulta.setMascotaId(consultaDTO.getMascotaId());
        consulta.setVeterinarioId(consultaDTO.getVeterinarioId());
        consulta.setFecha(consultaDTO.getFecha());
        consulta.setDescripcion(consultaDTO.getDescripcion());
        return consultaService.saveConsulta(consulta);
    }

    // Eliminar una consulta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable int id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
