package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.domain.repository.MascotaRepository;
import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> obtenerMascotaPorId(int id) {
        return mascotaRepository.findById(id);
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void eliminarMascota(int id) {
        mascotaRepository.deleteById(id);
    }
}