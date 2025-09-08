package com.group.cine.controller;

import com.group.cine.model.Funcion;
import com.group.cine.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funciones")
@CrossOrigin(origins = "*")
public class FuncionController {

    @Autowired
    private FuncionService FuncionService;

    @GetMapping
    public List<Funcion> listarFunciones() {
        return FuncionService.listarFunciones();
    }

    @PostMapping
    public Funcion crearFuncion(@RequestBody Funcion funcion) {
        return FuncionService.crearFuncion(funcion);
    }

    @GetMapping("/{id}")
    public Funcion obtenerFuncionPorId(@PathVariable Long id) {
        Optional<Funcion> funcion = FuncionService.obtenerFuncionPorId(id);
        return funcion.orElse(null);
    }

    @PutMapping("/{id}")
    public Funcion actualizarFuncion(@PathVariable Long id, @RequestBody Funcion detallesFuncion) {
        return FuncionService.actualizarFuncion(id, detallesFuncion);
    }

    @DeleteMapping("/{id}")
    public void eliminarFuncion(@PathVariable Long id) {
        FuncionService.eliminarFuncion(id);
    }

    @GetMapping("/sala/{salaId}")
    public List<Funcion> obtenerFuncionesPorSala(@PathVariable Long salaId) {
        return FuncionService.obtenerFuncionesPorSala(salaId);
    }

    @GetMapping("/pelicula/{peliculaId}")
    public List<Funcion> obtenerFuncionesPorPelicula(@PathVariable Long peliculaId) {
        return FuncionService.obtenerFuncionesPorPelicula(peliculaId);
    }
}
