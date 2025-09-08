package com.group.cine.repository;

import com.group.cine.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    List<Funcion> findBySalaId(Long salaId);
    List<Funcion> findByPeliculaId(Long peliculaId);
}
