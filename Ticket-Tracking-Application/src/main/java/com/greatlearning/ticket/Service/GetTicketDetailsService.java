package com.greatlearning.ticket.Service;

import java.util.List;

import com.greatlearning.ticket.Entity.Ticket;

public interface GetTicketDetailsService {

	List<Ticket> getTicketDetails();

	Ticket getTicketById(long id);

	Ticket getTicketByTitle(String title);
	

}