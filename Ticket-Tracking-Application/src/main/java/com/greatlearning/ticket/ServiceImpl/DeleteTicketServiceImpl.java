package com.greatlearning.ticket.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.Repository.TicketRepository;
import com.greatlearning.ticket.Service.DeleteTicketService;

@Service
public class DeleteTicketServiceImpl implements DeleteTicketService{

	@Autowired
	TicketRepository repository;
	
	
	@Override
	public void deleteTicketById(long id) {
		this.repository.deleteById(id);
	}
}
