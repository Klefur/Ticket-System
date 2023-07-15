package com.system.main.service;

import com.system.main.model.Rol;
import com.system.main.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    public Rol show(Long id) {
        return rolRepository.findById(id).get();
    }

    public String update(Rol rol, Long id) {
        Rol temp;
        try {
            temp = show(id);
            if(rol.getNombre() != null) {
                temp.setNombre(rol.getNombre());
            }
            rolRepository.save(temp);
            return "Rol actualizado";
        } catch (Exception e) {
            return "No existe rol con este id";
        }
    }
    public String delete(Long id) {
        try {
            rolRepository.deleteById(id);
            return "Rol eliminado";
        } catch (Exception e) {
            return "No existe rol con este ID";
        }
    }
}
