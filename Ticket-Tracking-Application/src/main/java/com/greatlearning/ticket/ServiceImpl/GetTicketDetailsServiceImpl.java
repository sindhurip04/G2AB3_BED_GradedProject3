package com.greatlearning.ticket.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket.Entity.Ticket;
import com.greatlearning.ticket.Repository.TicketRepository;
import com.greatlearning.ticket.Service.GetTicketDetailsService;

@Service
public class GetTicketDetailsServiceImpl implements GetTicketDetailsService {

	@Autowired
	TicketRepository repository;

	@Override
	public List<Ticket> getTicketDetails() {
		return repository.findAll();
	}

	@Override
	public Ticket getTicketById(long id) {
		Optional<Ticket> optional = repository.findById(id);
		Ticket ticket = null;
		if (optional.isPresent()) {
			ticket = optional.get();
		} else {
			throw new RuntimeException(" Ticket not found for id :: " + id);
		}
		return ticket;
	}
	
	@Override
	public Ticket getTicketByTitle(String title) {
		Ticket ticket = new Ticket();
		ticket.setTitle(title);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("title", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","shortDescription","content","date");
		Example<Ticket> example = Example.of(ticket, exampleMatcher);
		Optional<Ticket> optional = repository.findOne(example);
		Ticket ticket2 = null;
		if (optional.isPresent()) {
			ticket2 = optional.get();
		} else {
			throw new RuntimeException(" Ticket not found for id :: " + title);
		}
		return ticket2;
	}

}
