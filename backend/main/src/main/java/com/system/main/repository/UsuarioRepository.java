package com.system.main.repository;

import com.system.main.model.Area;
import com.system.main.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> getAllByArea(Area area);
    Optional<Usuario> getUsuarioByCorreo(String correo);
}
