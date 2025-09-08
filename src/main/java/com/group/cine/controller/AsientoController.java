package com.group.cine.controller;

import com.group.cine.model.Asiento;
import com.group.cine.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asientos")
@CrossOrigin(origins = "*")
public class AsientoController {

    @Autowired
    private AsientoService AsientoService;

    @GetMapping
    public List<Asiento> listarAsientos() {
        return AsientoService.listarAsientos();
    }

    @GetMapping("/funcion/{funcionId}")
    public List<Asiento> listarAsientosPorFuncion(@PathVariable Long funcionId) {
        return AsientoService.listarAsientosPorFuncion(funcionId);
    }

    @PostMapping
    public Asiento crearAsiento(@RequestBody Asiento asiento) {
        return AsientoService.crearAsiento(asiento);
    }

    @PutMapping("/{id}")
    public Asiento actualizarAsiento(@PathVariable Long id, @RequestBody Asiento detallesAsiento) {
        return AsientoService.actualizarAsiento(id, detallesAsiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarAsiento(@PathVariable Long id) {
        AsientoService.eliminarAsiento(id);
    }
}
