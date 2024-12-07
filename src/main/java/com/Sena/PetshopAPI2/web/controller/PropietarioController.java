package com.Sena.PetshopAPI2.web.controller;

import com.Sena.PetshopAPI2.domain.service.PropietarioService;
import com.Sena.PetshopAPI2.persistence.entity.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public List<Propietario> obtenerTodosLosPropietarios() {
        return propietarioService.obtenerTodosLosPropietarios();
    }

    @GetMapping("/{id}")
    public Propietario obtenerPropietarioPorId(@PathVariable int id) {
        return propietarioService.obtenerPropietarioPorId(id);
    }

    @PostMapping
    public Propietario guardarPropietario(@RequestBody Propietario propietario) {
        return propietarioService.guardarPropietario(propietario);
    }

    @DeleteMapping("/{id}")
    public void eliminarPropietario(@PathVariable int id) {
        propietarioService.eliminarPropietario(id);
    }
}
