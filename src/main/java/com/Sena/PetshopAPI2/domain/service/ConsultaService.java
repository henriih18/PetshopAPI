package com.Sena.PetshopAPI2.domain.service;

import com.Sena.PetshopAPI2.domain.dto.ConsultaDTO;
import com.Sena.PetshopAPI2.domain.repository.ConsultaRepository;
import com.Sena.PetshopAPI2.persistence.entity.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }


    public List<ConsultaDTO> getAllConsultas() {
        List<Consulta> consultas = (List<Consulta>) consultaRepository.findAll();
        return consultas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<ConsultaDTO> getConsultaById(int idConsulta) {
        Optional<Consulta> consulta = consultaRepository.findById(idConsulta);
        return consulta.map(this::convertToDTO);
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }


    public void deleteConsulta(int idConsulta) {
        consultaRepository.deleteById(idConsulta);
    }


    public List<ConsultaDTO> getConsultasByMascotaId(int idMascota) {
        List<Consulta> consultas = consultaRepository.findByMascota_IdConsulta(idMascota);
        return consultas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método que devuelve las consultas de un veterinario por su ID
    public List<ConsultaDTO> getConsultasByVeterinarioId(int idVeterinario) {
        List<Consulta> consultas = consultaRepository.findByVeterinario_IdConsulta(idVeterinario);
        return consultas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    private ConsultaDTO convertToDTO(Consulta consulta) {
        ConsultaDTO consultaDTO = new ConsultaDTO();
        consultaDTO.setIdConsulta(consulta.getIdConsulta());
        consultaDTO.setDescripcion(consulta.getDescripcion());
        consultaDTO.setFecha(consulta.getFecha());
        consultaDTO.setIdMascota(consulta.getMascota().getIdMascota());
        consultaDTO.setIdVeterinario(consulta.getVeterinario().getIdVeterinario());
        return consultaDTO;
    }
}
