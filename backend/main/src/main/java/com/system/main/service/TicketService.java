package com.system.main.service;

import com.system.main.model.Area;
import com.system.main.model.Estado;
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
        List<Ticket> tickets = getAllByRut(ticket.getRut());
        if (!(tickets.size() <= 5)) {
            return null;
        }
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getAllByRut(String rut) {
        return ticketRepository.findAllByRut(rut);
    }

    public List<Ticket> getAllByArea(Long idArea, Long idEstado) {
        Area area = new Area(idArea);
        Estado estado = new Estado(idEstado);

        return ticketRepository.findAllByAreaAndEstado(area, estado);
    }

    public Ticket show(Long id) {
        return ticketRepository.findById(id).get();
    }

    public String update(Ticket ticket, Long id) {
        Ticket temp;
        try {
            temp = show(id);
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
            if (ticket.getPrioridad() != null) {
                temp.setPrioridad(temp.getPrioridad());
            }
            if (ticket.getEstado() != null) {
                temp.setEstado(ticket.getEstado().getId());
            }
            if (ticket.getEncargado() != null) {
                temp.setEncargado(ticket.getEncargado().getId());
            }
            ticketRepository.save(ticket);
            return "Ticket actualizado";
        } catch (Exception e) {
            return e.toString();
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
