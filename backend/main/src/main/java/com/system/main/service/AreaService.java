package com.system.main.service;

import com.system.main.model.Area;
import com.system.main.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    public Area create(Area area) {
        return areaRepository.save(area);
    }

    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    public Area show(Long id) {
        return areaRepository.findById(id).get();
    }

    public String update(Area area, Long id) {
        Area temp;
        try {
            temp = show(id);
            if(area.getNombre() != null) {
                temp.setNombre(area.getNombre());
            }
            areaRepository.save(temp);
            return "Area actualizada";
        } catch (Exception e) {
            return "No existe area con este id";
        }
    }

    public String delete(Long id) {
        try {
            areaRepository.deleteById(id);
            return "Area eliminada";
        } catch (Exception e) {
            return "No existe area con este ID";
        }
    }
}
