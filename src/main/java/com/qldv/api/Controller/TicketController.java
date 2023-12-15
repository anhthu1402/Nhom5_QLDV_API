package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.Model.Ticket;
import com.qldv.api.Service.Implement.TicketService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tickets")
public class TicketController {
	@Autowired
	TicketService ticketService;

	//create ticket
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Ticket createTicket(@RequestBody Ticket ticketDetail) {
		return ticketService.createTicket(ticketDetail);
	}
	
	//get all tickets
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	//get ticket by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Ticket getTicketById(@PathVariable(value = "id") Integer id) {
		return ticketService.getTicketById(id);
	}
	
	//update ticket
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Ticket updateTicket(@PathVariable(value = "id") Integer id, @RequestBody Ticket ticketDetail) {
		return ticketService.updateTicket(id, ticketDetail);
	}
	
	//delete ticket
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean deleteTicket(@PathVariable(value = "id") Integer id) {
		return ticketService.deleteTicket(id);
	}
}
