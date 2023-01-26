package com.greatlearning.ticket.Service;

import com.greatlearning.ticket.Entity.Ticket;

public interface CreateTicketService {

	Ticket createTicket(Ticket ticket);

	String updateTicket(Long id);

	void saveTicket(Ticket ticket);

}