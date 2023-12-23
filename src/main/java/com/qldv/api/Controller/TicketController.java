package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.Exception.NotFoundException;
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
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticketDetail) {
		Ticket ticket = ticketService.createTicket(ticketDetail);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
	
	//get all tickets
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> tickets = ticketService.getAllTickets();
	    return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	//get ticket by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Integer id) {
		Ticket ticket = ticketService.getTicketById(id);
		if(ticket == null){
            throw new NotFoundException("Không tìm thấy vé có id là: " + id);
        }
	    return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	//update ticket
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Integer id, @RequestBody Ticket ticketDetail) {
		try {
			Ticket ticket = ticketService.updateTicket(id, ticketDetail);;
		    return new ResponseEntity<>(ticket, HttpStatus.OK);
		}catch(Exception e) {
			 throw new NotFoundException("Không tìm thấy vé có id là: " + id);
		}
	}
	
	//delete ticket
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean deleteTicket(@PathVariable(value = "id") Integer id) {
		return ticketService.deleteTicket(id);
	}
}
