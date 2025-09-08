package com.group.cine.controller;

import com.group.cine.model.Venta;
import com.group.cine.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService VentaService;

    @GetMapping
    public List<Venta> listarVentas() {
        return VentaService.listarVentas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id) {
        Optional<Venta> venta = VentaService.obtenerVentaPorId(id);
        return venta.orElse(null);
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return VentaService.crearVenta(venta);
    }
}
