package com.group.cine.service;

import com.group.cine.model.Pelicula;
import com.group.cine.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula actualizarPelicula(Long id, Pelicula detallesPelicula) {
        return peliculaRepository.findById(id).map(pelicula -> {
            pelicula.setTitulo(detallesPelicula.getTitulo());
            pelicula.setGenero(detallesPelicula.getGenero());
            pelicula.setDuracion(detallesPelicula.getDuracion());
            pelicula.setImagen(detallesPelicula.getImagen()); // <- nuevo
            return peliculaRepository.save(pelicula);
        }).orElse(null);
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
