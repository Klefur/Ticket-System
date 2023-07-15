package com.system.main.service;

import com.system.main.model.Ticket;
import com.system.main.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getAllByRut(String rut) {
        return ticketRepository.findAllByRut(rut);
    }

    public Ticket show(Long id) {
        return ticketRepository.findById(id).get();
    }

    public String update(Ticket ticket, Long id) {
        Ticket temp;
        try {
            temp = show(id);
            if (ticket.getNombre() != null) {
                temp.setNombre(ticket.getNombre());
            }
            if (ticket.getApellido() != null) {
                temp.setApellido(ticket.getApellido());
            }
            if (ticket.getRut() != null) {
                temp.setRut(ticket.getRut());
            }
            if (ticket.getCorreo() != null) {
                temp.setCorreo(ticket.getCorreo());
            }
            if (ticket.getAsunto() != null) {
                temp.setAsunto(ticket.getAsunto());
            }
            if (ticket.getArea() != null) {
                temp.setArea(ticket.getArea().getId());
            }
            if (ticket.getEstado() != null) {
                temp.setEstado(ticket.getEstado().getId());
            }
            ticketRepository.save(ticket);
            return "Ticket actualizado";
        } catch (Exception e) {
            return "No existe ticket con este id";
        }
    }
    public String delete(Long id) {
        try {
            ticketRepository.deleteById(id);
            return "Ticket eliminado";
        } catch (Exception e) {
            return "No existe ticket con este ID";
        }
    }
}
