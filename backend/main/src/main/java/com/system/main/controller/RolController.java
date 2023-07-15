package com.system.main.controller;

import com.system.main.model.Rol;
import com.system.main.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolService rolService;

    @PostMapping()
    public Rol guardar(@RequestBody Rol rol) {
        return rolService.create(rol);
    }

    @GetMapping()
    public List<Rol> getAll() {
        return rolService.getAll();
    }

    @GetMapping("/{id}")
    public Rol getArea(@PathVariable Long id) {
        return rolService.show(id);
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Rol rol, @PathVariable Long id) {
        return rolService.update(rol, id);
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id) {
        return rolService.delete(id);
    }
}
