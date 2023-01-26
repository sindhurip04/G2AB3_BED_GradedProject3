package com.greatlearning.ticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.ticket.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
