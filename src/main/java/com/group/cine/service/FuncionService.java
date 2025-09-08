package com.group.cine.service;

import com.group.cine.model.Funcion;
import com.group.cine.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    public List<Funcion> listarFunciones() {
        return funcionRepository.findAll();
    }

    public Optional<Funcion> obtenerFuncionPorId(Long id) {
        return funcionRepository.findById(id);
    }

    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    public Funcion actualizarFuncion(Long id, Funcion detallesFuncion) {
        return funcionRepository.findById(id).map(funcion -> {
            funcion.setFechaHora(detallesFuncion.getFechaHora());
            funcion.setSala(detallesFuncion.getSala());
            funcion.setPelicula(detallesFuncion.getPelicula());
            return funcionRepository.save(funcion);
        }).orElse(null);
    }

    public void eliminarFuncion(Long id) {
        funcionRepository.deleteById(id);
    }

    public List<Funcion> obtenerFuncionesPorSala(Long salaId) {
        return funcionRepository.findBySalaId(salaId);
    }

    public List<Funcion> obtenerFuncionesPorPelicula(Long peliculaId) {
        return funcionRepository.findByPeliculaId(peliculaId);
    }
}
