package com.group.cine.controller;

import com.group.cine.model.Sala;
import com.group.cine.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
@CrossOrigin(origins = "*")
public class SalaController {

    @Autowired
    private SalaService SalaService;

    @GetMapping
    public List<Sala> listarSalas() {
        return SalaService.listarSalas();
    }

    @PostMapping
    public Sala crearSala(@RequestBody Sala sala) {
        return SalaService.crearSala(sala);
    }

    @GetMapping("/{id}")
    public Sala obtenerSalaPorId(@PathVariable Long id) {
        Optional<Sala> sala = SalaService.obtenerSalaPorId(id);
        return sala.orElse(null);
    }

    @PutMapping("/{id}")
    public Sala actualizarSala(@PathVariable Long id, @RequestBody Sala detallesSala) {
        return SalaService.actualizarSala(id, detallesSala);
    }

    @DeleteMapping("/{id}")
    public void eliminarSala(@PathVariable Long id) {
        SalaService.eliminarSala(id);
    }
}
