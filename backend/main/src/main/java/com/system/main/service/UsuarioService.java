package com.system.main.service;

import com.system.main.model.Usuario;
import com.system.main.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario show(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public String update(Usuario usuario, Long id) {
        Usuario temp;
        try {
            temp = show(id);
            if (usuario.getNombre() != null) {
                temp.setNombre(usuario.getNombre());
            }
            if (usuario.getApellido() != null) {
                temp.setApellido(usuario.getApellido());
            }
            if (usuario.getRut() != null) {
                temp.setRut(usuario.getRut());
            }
            if (usuario.getCorreo() != null) {
                temp.setCorreo(usuario.getCorreo());
            }
            if (usuario.getClave() != null) {
                temp.setClave(usuario.getClave());
            }
            if (usuario.getRol() != null) {
                temp.setRol(usuario.getRol().getId());
            }
            if (usuario.getArea() != null) {
                temp.setArea(usuario.getArea().getId());
            }
            usuarioRepository.save(usuario);
            return "Usuario actualizado";
        } catch (Exception e) {
            return "No existe usuario con este id";
        }
    }
    public String delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return "Usuario eliminado";
        } catch (Exception e) {
            return "No existe usuario con este ID";
        }
    }
}
