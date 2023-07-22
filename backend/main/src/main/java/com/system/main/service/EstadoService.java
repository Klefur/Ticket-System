package com.system.main.service;

import com.system.main.model.Estado;
import com.system.main.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado create(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> getAll() {
        return estadoRepository.findAll();
    }

    public Estado show(Long id) {
        return estadoRepository.findById(id).get();
    }

    public String update(Estado estado, Long id) {
        Estado temp;
        try {
            temp = show(id);
            if(estado.getNombre() != null) {
                temp.setNombre(estado.getNombre());
            }
            estadoRepository.save(temp);
            return "Estado actualizado";
        } catch (Exception e) {
            return "No existe estado con este id";
        }
    }

    public String delete(Long id) {
        try {
            estadoRepository.deleteById(id);
            return "Estado eliminado";
        } catch (Exception e) {
            return "No existe estado con este ID";
        }
    }
}
