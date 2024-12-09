package com.Sena.PetshopAPI2.domain.repository;

import com.Sena.PetshopAPI2.persistence.crud.ConsultaCrudRepository;
import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultaRepository extends ConsultaCrudRepository <Consulta, Integer> {

}
