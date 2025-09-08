package com.group.cine.repository;

import com.group.cine.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {
    List<Asiento> findByFuncionId(Long funcionId);
}
