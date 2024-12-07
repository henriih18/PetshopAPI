package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.persistence.entity.Propietario;
import com.Sena.PetshopAPI2.domain.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> obtenerTodosLosPropietarios() {
        return propietarioRepository.findAll();
    }

    public Propietario obtenerPropietarioPorId(int id) {
        return propietarioRepository.findById(id).orElse(null);
    }

    public Propietario guardarPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public void eliminarPropietario(int id) {
        propietarioRepository.deleteById(id);
    }
}
