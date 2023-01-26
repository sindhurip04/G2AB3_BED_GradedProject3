package com.greatlearning.ticket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.ticket.Entity.Ticket;
import com.greatlearning.ticket.Service.GetTicketDetailsService;

@Controller
@RequestMapping("/admin/tickets")
public class GetController {

	@Autowired
	GetTicketDetailsService getTicketDetailsService;
	
	@GetMapping("/")
	public String getTicketDetails(Model model) {
		List<Ticket> tickets = getTicketDetailsService.getTicketDetails();
		model.addAttribute("Ticket", tickets);
		return "home-page";
	}
	
	@GetMapping("/{id}/view")
	public String getTicket(@PathVariable(value="id")long id, Model model) {
		Ticket ticket = getTicketDetailsService.getTicketById(id);
		model.addAttribute("SingleTicket", ticket);
		return "view-ticket";
	}
	
	 @GetMapping("/search")
	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
	        Ticket tickets = getTicketDetailsService.getTicketByTitle(keyword);
	        model.addAttribute("tickets", tickets);
	        model.addAttribute("keyword", keyword);
	         
	        return "search-ticket";
	    }
}