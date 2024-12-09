package com.Sena.PetshopAPI2.domain.repository;

import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.stereotype.Repository;
import com.Sena.PetshopAPI2.persistence.crud.VeterinarioCrudRepository;

@Repository
public interface VeterinarioRepository extends VeterinarioCrudRepository<Veterinario, Integer> {

}
