package com.Sena.PetshopAPI2.web.controller;

import com.Sena.PetshopAPI2.domain.dto.VeterinarioDTO;
import com.Sena.PetshopAPI2.domain.service.VeterinarioService;
import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    // Obtener todos los veterinarios
    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> getAllVeterinarios() {
        List<VeterinarioDTO> veterinarios = veterinarioService.getAllVeterinarios();
        return ResponseEntity.ok(veterinarios);
    }

    // Obtener veterinario por ID
    @GetMapping("/{idVeterinario}")
    public ResponseEntity<VeterinarioDTO> getVeterinarioById(@PathVariable int idVeterinario) {
        Optional<Veterinario> optionalVeterinario = veterinarioService.obtenerVeterinarioPorId(idVeterinario);

        if (optionalVeterinario.isPresent()) {
            Veterinario veterinario = optionalVeterinario.get();
            VeterinarioDTO veterinarioDTO = new VeterinarioDTO();
            veterinarioDTO.setIdVeterinario(veterinario.getIdVeterinario());
            veterinarioDTO.setNombre(veterinario.getNombre());
            veterinarioDTO.setApellido(veterinario.getApellido());
            veterinarioDTO.setEspecialidad(veterinario.getEspecialidad());

            return ResponseEntity.ok(veterinarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Crear un nuevo veterinario
    @PostMapping
    public ResponseEntity<VeterinarioDTO> createVeterinario(@RequestBody VeterinarioDTO veterinarioDTO) {
        VeterinarioDTO newVeterinario = veterinarioService.createVeterinario(veterinarioDTO);
        return ResponseEntity.ok(newVeterinario);
    }

    // Actualizar un veterinario
    @PutMapping("/{idVeterinario}")
    public ResponseEntity<VeterinarioDTO> updateVeterinario(@PathVariable int idVeterinario, @RequestBody VeterinarioDTO veterinarioDTO) {
        VeterinarioDTO updatedVeterinario = veterinarioService.updateVeterinario(idVeterinario, veterinarioDTO);
        if (updatedVeterinario != null) {
            return ResponseEntity.ok(updatedVeterinario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un veterinario
    @DeleteMapping("/{idVeterinario}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable int idVeterinario) {
        boolean isDeleted = veterinarioService.deleteVeterinario(idVeterinario);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
