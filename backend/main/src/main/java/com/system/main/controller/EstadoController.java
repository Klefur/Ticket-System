package com.system.main.controller;

import com.system.main.model.Estado;
import com.system.main.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @PostMapping()
    public Estado guardar(@RequestBody Estado estado) {
        return estadoService.create(estado);
    }

    @GetMapping()
    public List<Estado> getAll() {
        return estadoService.getAll();
    }

    @GetMapping("/{id}")
    public Estado getArea(@PathVariable Long id) {
        return estadoService.show(id);
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Estado estado, @PathVariable Long id) {
        return estadoService.update(estado, id);
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id) {
        return estadoService.delete(id);
    }
}
