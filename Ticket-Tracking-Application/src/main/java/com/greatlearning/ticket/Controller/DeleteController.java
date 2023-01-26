package com.greatlearning.ticket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ticket.Service.DeleteTicketService;

@Controller
@RequestMapping("/admin/tickets")
public class DeleteController {

	@Autowired
	DeleteTicketService deleteTicketService;
	
	@GetMapping("/{id}/delete")
	public String deleteTicket(@PathVariable(value="id") Long id ) {
		deleteTicketService.deleteTicketById(id);
		return "redirect:/admin/tickets/";
	}
	
}
