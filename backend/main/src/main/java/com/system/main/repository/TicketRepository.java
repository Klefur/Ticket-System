package com.system.main.repository;

import com.system.main.model.Area;
import com.system.main.model.Estado;
import com.system.main.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByRut(String rut);
    List<Ticket> findAllByAreaAndEstado(Area area, Estado estado);
}
