package com.Sena.PetshopAPI2.web.controller;


import com.Sena.PetshopAPI2.domain.service.VeterinarioService;
import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.getAllVeterinarios();
    }

    @GetMapping("/{id}")
    public Optional<Veterinario> getVeterinarioById(@PathVariable int id) {
        return veterinarioService.getVeterinarioById(id);
    }

    @PostMapping
    public Veterinario createVeterinario(@RequestBody Veterinario veterinario) {
        return veterinarioService.saveVeterinario(veterinario);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterinario(@PathVariable int id) {
        veterinarioService.deleteVeterinario(id);
    }
}
