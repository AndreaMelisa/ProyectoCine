package com.group.cine.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int duracion;
    private String imagen;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getImagen() { return imagen; } // <- GETTER
    public void setImagen(String imagen) { this.imagen = imagen; } // <- SETTER

    public List<Funcion> getFunciones() { return funciones; }
    public void setFunciones(List<Funcion> funciones) { this.funciones = funciones; }
}
