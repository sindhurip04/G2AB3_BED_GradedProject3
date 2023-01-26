package com.greatlearning.ticket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ticket.Entity.Ticket;
import com.greatlearning.ticket.Service.CreateTicketService;
import com.greatlearning.ticket.Service.GetTicketDetailsService;

@Controller
@RequestMapping("/admin/tickets")
public class CreateController {
	
	@Autowired
	CreateTicketService createTicket;
	
	@Autowired
	GetTicketDetailsService detailsService;
	
	@GetMapping("/newTicket")
	public String getNewTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("TicketDetails",ticket);
		return "create-ticket";
	}
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("TicketDetails") Ticket ticket ) {
		ticket.setDate(java.time.LocalDate.now());
		createTicket.saveTicket(ticket);
		System.out.println(ticket.getDate());
		return "redirect:/admin/tickets/";
	}
	@GetMapping("/{id}/edit")
	public String updateTicket(@PathVariable(value ="id") Long id, Model model) {
		Ticket ticket = detailsService.getTicketById(id);
		model.addAttribute("TicketDetails", ticket);
		return "update-ticket";
	}
	
}
