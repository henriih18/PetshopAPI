package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.domain.dto.MascotaDTO;
import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import com.Sena.PetshopAPI2.persistence.crud.MascotaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaCrudRepository mascotaCrudRepository;

    public List<Mascota> obtenerTodasLasMascotas() {
        return (List<Mascota>) mascotaCrudRepository.findAll();
    }

    public Optional<Mascota> obtenerMascotaPorId(Integer idMascota) {
        return mascotaCrudRepository.findById(idMascota);
    }

    public Mascota guardarMascota(MascotaDTO mascotaDTO) {
        // Convertir el DTO a una entidad
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setGenero(mascotaDTO.getGenero());
        mascota.setRaza(mascotaDTO.getRaza());
        mascota.setEdad(mascotaDTO.getEdad());

        return mascotaCrudRepository.save(mascota);
    }

    // Actualizar una mascota existente
    public Mascota actualizarMascota(Integer idMascota, MascotaDTO mascotaDTO) {
        // Buscar la mascota por su ID
        Mascota mascotaExistente = mascotaCrudRepository.findById(idMascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        mascotaExistente.setNombre(mascotaDTO.getNombre());
        mascotaExistente.setGenero(mascotaDTO.getGenero());
        mascotaExistente.setRaza(mascotaDTO.getRaza());
        mascotaExistente.setEdad(mascotaDTO.getEdad());
        return mascotaCrudRepository.save(mascotaExistente);
    }

    public void eliminarMascota(Integer idMascota) {
        mascotaCrudRepository.deleteById(idMascota);
    }

    public List<Mascota> getMascotasByPropietarioId(Integer idPropietario) {
        return mascotaCrudRepository.findByPropietario_Id(idPropietario);
    }

    public List<Mascota> getMascotasByVeterinarioId(Integer idVeterinario) {
        return mascotaCrudRepository.findByVeterinario_Id(idVeterinario);
    }
}
