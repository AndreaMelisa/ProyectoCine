package com.group.cine.service;

import com.group.cine.model.Sala;
import com.group.cine.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> obtenerSalaPorId(Long id) {
        return salaRepository.findById(id);
    }

    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala actualizarSala(Long id, Sala detallesSala) {
        return salaRepository.findById(id).map(sala -> {
            sala.setNombre(detallesSala.getNombre());
            sala.setCapacidad(detallesSala.getCapacidad());
            return salaRepository.save(sala);
        }).orElse(null);
    }

    public void eliminarSala(Long id) {
        salaRepository.deleteById(id);
    }
}
