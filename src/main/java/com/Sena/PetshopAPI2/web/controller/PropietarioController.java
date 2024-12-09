package com.Sena.PetshopAPI2.web.controller;

import com.Sena.PetshopAPI2.domain.dto.PropietarioDTO;
import com.Sena.PetshopAPI2.domain.service.PropietarioService;
import com.Sena.PetshopAPI2.persistence.entity.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public ResponseEntity<List<Propietario>> obtenerTodosLosPropietarios() {
        return new ResponseEntity<>(propietarioService.obtenerTodosLosPropietarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> obtenerPropietarioPorId(@PathVariable("id") Integer idPropietario) {
        return propietarioService.obtenerPropietarioPorId(idPropietario)
                .map(propietario -> new ResponseEntity<>(propietario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Propietario> guardarPropietario(@RequestBody PropietarioDTO propietarioDTO) {
        return new ResponseEntity<>(propietarioService.guardarPropietario(propietarioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propietario> actualizarPropietario(
            @PathVariable("id") Integer idPropietario,
            @RequestBody PropietarioDTO propietarioDTO) {
        return new ResponseEntity<>(propietarioService.actualizarPropietario(idPropietario, propietarioDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable("id") Integer idPropietario) {
        propietarioService.eliminarPropietario(idPropietario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
