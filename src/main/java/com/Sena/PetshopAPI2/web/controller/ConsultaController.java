package com.Sena.PetshopAPI2.web.controller;

import com.Sena.PetshopAPI2.domain.dto.ConsultaDTO;
import com.Sena.PetshopAPI2.domain.dto.VeterinarioDTO;
import com.Sena.PetshopAPI2.domain.service.ConsultaService;
import com.Sena.PetshopAPI2.domain.service.MascotaService;
import com.Sena.PetshopAPI2.domain.service.VeterinarioService;
import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private VeterinarioService veterinarioService;

    // Obtener todas las consultas
    @GetMapping
    public List<ConsultaDTO> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    // Obtener consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> getConsultaById(@PathVariable int id) {
        return consultaService.getConsultaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener todas las consultas de una mascota por su ID
    @GetMapping("/mascota/{idMascota}")
    public List<ConsultaDTO> getConsultasByMascotaId(@PathVariable int idMascota) {
        return consultaService.getConsultasByMascotaId(idMascota);
    }

    // Obtener todas las consultas de un veterinario por su ID
    @GetMapping("/veterinario/{idVeterinario}")
    public List<ConsultaDTO> getConsultasByVeterinarioId(@PathVariable int idVeterinario) {
        return consultaService.getConsultasByVeterinarioId(idVeterinario);
    }

    // Crear una nueva consulta
    @PostMapping
    public ResponseEntity<ConsultaDTO> createConsulta(@RequestBody ConsultaDTO consultaDTO) {
        // Buscar la mascota por su ID
        Optional<Mascota> optionalMascota = mascotaService.obtenerMascotaPorId(consultaDTO.getIdMascota());
        if (optionalMascota.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Mascota mascota = optionalMascota.get();


        Optional<Veterinario> optionalVeterinario = veterinarioService.obtenerVeterinarioPorId(consultaDTO.getIdVeterinario());
        if (optionalVeterinario.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Veterinario veterinario = optionalVeterinario.get();

// Convertir el veterinario a VeterinarioDTO
        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
        veterinarioDTO.setIdVeterinario(veterinario.getIdVeterinario());
        veterinarioDTO.setNombre(veterinario.getNombre());
        veterinarioDTO.setApellido(veterinario.getApellido());
        veterinarioDTO.setEspecialidad(veterinario.getEspecialidad());


        // Convertir el ConsultaDTO a Consulta (Entidad)
        Consulta consulta = new Consulta();
        consulta.setDescripcion(consultaDTO.getDescripcion());
        consulta.setFecha(consultaDTO.getFecha());
        consulta.setMascota(mascota);
        consulta.setVeterinario(veterinario);


        Consulta savedConsulta = consultaService.saveConsulta(consulta);


        ConsultaDTO savedConsultaDTO = new ConsultaDTO();
        savedConsultaDTO.setIdConsulta(savedConsulta.getIdConsulta());
        savedConsultaDTO.setDescripcion(savedConsulta.getDescripcion());
        savedConsultaDTO.setFecha(savedConsulta.getFecha());
        savedConsultaDTO.setIdMascota(savedConsulta.getMascota().getIdMascota());
        savedConsultaDTO.setIdVeterinario(savedConsulta.getVeterinario().getIdVeterinario());


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedConsultaDTO.getIdConsulta())
                .toUri();
        return ResponseEntity.created(location).body(savedConsultaDTO);
    }

    // Eliminar una consulta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable int idVeterinario) {
        consultaService.deleteConsulta(idVeterinario);
        return ResponseEntity.noContent().build();
    }


}
