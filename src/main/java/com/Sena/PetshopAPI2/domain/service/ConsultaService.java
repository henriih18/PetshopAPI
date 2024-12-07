package com.Sena.PetshopAPI2.domain.service;


import com.Sena.PetshopAPI2.domain.repository.ConsultaRepository;
import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(int id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> getConsultasByMascotaId(int mascotaId) {
        return consultaRepository.findByMascota_Id(mascotaId);
    }

    public List<Consulta> getConsultasByVeterinarioId(int veterinarioId) {
        return consultaRepository.findByVeterinario_Id(veterinarioId);
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(int id) {
        consultaRepository.deleteById(id);
    }
}
