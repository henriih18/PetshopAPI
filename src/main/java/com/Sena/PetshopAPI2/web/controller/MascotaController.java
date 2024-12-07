package com.Sena.PetshopAPI2.web.controller;

import com.Sena.PetshopAPI2.domain.service.MascotaService;
import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    @GetMapping("/{id}")
    public Optional<Mascota> obtenerMascotaPorId(@PathVariable int id) {
        return mascotaService.obtenerMascotaPorId(id);
    }

    @PostMapping
    public Mascota guardarMascota(@RequestBody Mascota mascota) {
        return mascotaService.guardarMascota(mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable int id) {
        mascotaService.eliminarMascota(id);
    }
}
