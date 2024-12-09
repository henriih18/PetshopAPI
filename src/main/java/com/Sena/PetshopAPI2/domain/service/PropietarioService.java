package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.domain.dto.PropietarioDTO;
import com.Sena.PetshopAPI2.persistence.crud.PropietarioCrudRepository;
import com.Sena.PetshopAPI2.persistence.entity.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioCrudRepository propietarioCrudRepository;

    public List<Propietario> obtenerTodosLosPropietarios() {
        return (List<Propietario>) propietarioCrudRepository.findAll();
    }

    public Optional<Propietario> obtenerPropietarioPorId(Integer idPropietario) {
        return propietarioCrudRepository.findById(idPropietario);
    }

    public Propietario guardarPropietario(PropietarioDTO propietarioDTO) {
        Propietario propietario = new Propietario();
        propietario.setNombre(propietarioDTO.getNombre());
        propietario.setApellido(propietarioDTO.getApellido());
        propietario.setCorreoElectronico(propietarioDTO.getCorreoElectronico());
        propietario.setDireccion(propietarioDTO.getDireccion());
        propietario.setTelefono(propietarioDTO.getTelefono());

        return propietarioCrudRepository.save(propietario);
    }

    public Propietario actualizarPropietario(Integer idPropietario, PropietarioDTO propietarioDTO) {
        Propietario propietarioExistente = propietarioCrudRepository.findById(idPropietario)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado"));

        propietarioExistente.setNombre(propietarioDTO.getNombre());
        propietarioExistente.setApellido(propietarioDTO.getApellido());
        propietarioExistente.setCorreoElectronico(propietarioDTO.getCorreoElectronico());
        propietarioExistente.setDireccion(propietarioDTO.getDireccion());
        propietarioExistente.setTelefono(propietarioDTO.getTelefono());

        return propietarioCrudRepository.save(propietarioExistente);
    }

    public void eliminarPropietario(Integer idPropietario) {
        propietarioCrudRepository.deleteById(idPropietario);
    }
}
