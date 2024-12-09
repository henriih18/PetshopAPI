package com.Sena.PetshopAPI2.persistence.crud;

import com.Sena.PetshopAPI2.persistence.entity.Mascota;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MascotaCrudRepository extends CrudRepository<Mascota, Integer> {
    List<Mascota> findByPropietario_Id(Integer id);
    List<Mascota> findByVeterinario_Id(Integer id);
}
