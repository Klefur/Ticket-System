package com.system.main.controller;

import com.system.main.model.Ticket;
import com.system.main.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping()
    public Ticket guardar(@RequestBody Ticket ticket) {
        ticket.setEstado(1L);
        return ticketService.create(ticket);
    }

    @GetMapping()
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.show(id);
    }

    @GetMapping("/rut/{rut}")
    public List<Ticket> getByRut(@PathVariable String rut) {
        return ticketService.getAllByRut(rut);
    }

    @GetMapping("/area/{idArea}estado{idEstado}")
    public List<Ticket> getByRut(@PathVariable Long idArea, @PathVariable Long idEstado) {
        return ticketService.getAllByArea(idArea, idEstado);
    }

    @PutMapping("/{id}")
    public String actualizar(@RequestBody Ticket ticket, @PathVariable Long id) {
        return ticketService.update(ticket, id);
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id) {
        return ticketService.delete(id);
    }
}
