package com.group.cine.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public List<Funcion> getFunciones() { return funciones; }
    public void setFunciones(List<Funcion> funciones) { this.funciones = funciones; }
}
