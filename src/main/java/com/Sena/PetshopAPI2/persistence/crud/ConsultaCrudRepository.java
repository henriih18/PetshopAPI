package com.Sena.PetshopAPI2.persistence.crud;

import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ConsultaCrudRepository<C, I extends Number> extends CrudRepository<Consulta, Integer> {

    List<Consulta> findByMascota_IdConsulta(Integer idMascota);

    List<Consulta> findByVeterinario_IdConsulta(Integer idVeterinario);
}
