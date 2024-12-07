package com.Sena.PetshopAPI2.domain.service;


import com.Sena.PetshopAPI2.domain.repository.VeterinarioRepository;
import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public List<Veterinario> getAllVeterinarios() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> getVeterinarioById(int id) {
        return veterinarioRepository.findById(id);
    }

    public Veterinario saveVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public void deleteVeterinario(int id) {
        veterinarioRepository.deleteById(id);
    }
}
