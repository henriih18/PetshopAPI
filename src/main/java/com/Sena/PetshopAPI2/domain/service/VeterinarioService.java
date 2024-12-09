package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.domain.dto.VeterinarioDTO;
import com.Sena.PetshopAPI2.domain.repository.VeterinarioRepository;
import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    // Obtener todos los veterinarios
    public List<VeterinarioDTO> getAllVeterinarios() {
        return ((List<Veterinario>) veterinarioRepository.findAll()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // Obtener un veterinario por su ID
    public Optional<Veterinario> obtenerVeterinarioPorId(Integer idVeterinario) {
        return veterinarioRepository.findById(idVeterinario);
    }


    // Crear un nuevo veterinario
    public VeterinarioDTO createVeterinario(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = convertToEntity(veterinarioDTO);
        Veterinario savedVeterinario = veterinarioRepository.save(veterinario);
        return convertToDTO(savedVeterinario);
    }

    // Actualizar un veterinario
    public VeterinarioDTO updateVeterinario(Integer idVeterinario, VeterinarioDTO veterinarioDTO) {
        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(idVeterinario);
        if (veterinarioOptional.isPresent()) {
            Veterinario veterinario = veterinarioOptional.get();
            veterinario.setNombre(veterinarioDTO.getNombre());
            veterinario.setApellido(veterinarioDTO.getApellido());
            veterinario.setEspecialidad(veterinarioDTO.getEspecialidad());
            Veterinario updatedVeterinario = veterinarioRepository.save(veterinario);
            return convertToDTO(updatedVeterinario);
        }
        return null;
    }

    // Eliminar un veterinario por su ID
    public boolean deleteVeterinario(Integer idVeterinario) {
        Optional<Veterinario> veterinario = veterinarioRepository.findById(idVeterinario);
        if (veterinario.isPresent()) {
            veterinarioRepository.delete(veterinario.get());
            return true;
        }
        return false;
    }

    // Métodos privados para conversión entre DTO y entidad
    private VeterinarioDTO convertToDTO(Veterinario veterinario) {
        return new VeterinarioDTO(
                veterinario.getIdVeterinario(),
                veterinario.getNombre(),
                veterinario.getApellido(),
                veterinario.getEspecialidad()
        );
    }

    private Veterinario convertToEntity(VeterinarioDTO veterinarioDTO) {
        Veterinario veterinario = new Veterinario();
        veterinario.setNombre(veterinarioDTO.getNombre());
        veterinario.setApellido(veterinarioDTO.getApellido());
        veterinario.setEspecialidad(veterinarioDTO.getEspecialidad());
        return veterinario;
    }


}
