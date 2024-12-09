package com.Sena.PetshopAPI2.web.controller;


import com.Sena.PetshopAPI2.domain.dto.MascotaDTO;
import com.Sena.PetshopAPI2.domain.service.MascotaService;
import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // Obtener todas las mascotas
    @GetMapping
    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    // Obtener una mascota por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mascota>> obtenerMascotaPorId(@PathVariable int id) {
        return ResponseEntity.ok(mascotaService.obtenerMascotaPorId(id));
    }

    // Crear una nueva mascota
    @PostMapping
    public ResponseEntity<Mascota> guardarMascota(@RequestBody MascotaDTO mascotaDTO) {
        Mascota savedMascota = mascotaService.guardarMascota(mascotaDTO);
        return ResponseEntity.ok(savedMascota);
    }

    // Actualizar una mascota
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable int id, @RequestBody MascotaDTO mascotaDTO) {
        Mascota updatedMascota = mascotaService.actualizarMascota(id, mascotaDTO);
        return ResponseEntity.ok(updatedMascota);
    }

    // Eliminar una mascota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable int id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }
}
