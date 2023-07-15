package com.system.main.controller;

import com.system.main.model.Area;
import com.system.main.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    @PostMapping()
    public Area guardar(@RequestBody Area area) {
        return areaService.create(area);
    }

    @GetMapping()
    public List<Area> getAll() {
        return areaService.getAll();
    }

    @GetMapping("/{id}")
    public Area getArea(@PathVariable Long id) {
        return areaService.show(id);
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Area area, @PathVariable Long id) {
        return areaService.update(area, id);
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id) {
        return areaService.delete(id);
    }
}
