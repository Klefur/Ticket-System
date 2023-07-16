package com.system.main.controller;

import com.system.main.model.Area;
import com.system.main.model.Usuario;
import com.system.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"http://localhost:8086/", "http://127.0.0.1:5173/"})
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public Usuario guardar(@RequestBody Usuario usuario) {
        if (usuario.getArea() == null) {
            usuario.setRol(1L);
        }
        return usuarioService.create(usuario);
    }

    @GetMapping()
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.show(id);
    }

    @GetMapping("/area/{id}")
    public List<Usuario> getAllByRol(@PathVariable Long id) {
        return usuarioService.getAllByArea(id);
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.update(usuario, id);
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id) {
        return usuarioService.delete(id);
    }
}
