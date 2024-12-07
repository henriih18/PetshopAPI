package com.Sena.PetshopAPI2.domain.repository;

import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByMascota_Id(int mascotaId);
    List<Consulta> findByVeterinario_Id(int veterinarioId);
}
