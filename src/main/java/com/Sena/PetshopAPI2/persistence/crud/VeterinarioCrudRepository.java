package com.Sena.PetshopAPI2.persistence.crud;

import com.Sena.PetshopAPI2.persistence.entity.Veterinario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VeterinarioCrudRepository<V, I extends Number> extends CrudRepository<Veterinario, Integer> {
    void deleteVeterinario(Optional<Veterinario> veterinario);

}
