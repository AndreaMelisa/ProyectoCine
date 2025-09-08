package com.group.cine.controller;

import com.group.cine.model.Pelicula;
import com.group.cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService PeliculaService;

    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return PeliculaService.listarPeliculas();
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return PeliculaService.crearPelicula(pelicula);
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Long id) {
        Optional<Pelicula> pelicula = PeliculaService.obtenerPeliculaPorId(id);
        return pelicula.orElse(null);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula detallesPelicula) {
        return PeliculaService.actualizarPelicula(id, detallesPelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        PeliculaService.eliminarPelicula(id);
    }
}
