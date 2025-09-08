package com.group.cine.service;

import com.group.cine.model.Asiento;
import com.group.cine.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    public List<Asiento> listarAsientos() {
        return asientoRepository.findAll();
    }

    public Optional<Asiento> obtenerAsientoPorId(Long id) {
        return asientoRepository.findById(id);
    }

    public List<Asiento> listarAsientosPorFuncion(Long funcionId) {
        return asientoRepository.findByFuncionId(funcionId);
    }

    public Asiento crearAsiento(Asiento asiento) {
        return asientoRepository.save(asiento);
    }

    public Asiento actualizarAsiento(Long id, Asiento detallesAsiento) {
        return asientoRepository.findById(id).map(asiento -> {
            asiento.setFila(detallesAsiento.getFila());
            asiento.setNumero(detallesAsiento.getNumero());
            asiento.setOcupado(detallesAsiento.isOcupado());
            asiento.setFuncion(detallesAsiento.getFuncion());
            return asientoRepository.save(asiento);
        }).orElse(null);
    }

    public void eliminarAsiento(Long id) {
        asientoRepository.deleteById(id);
    }
}
