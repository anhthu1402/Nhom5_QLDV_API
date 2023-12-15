package com.qldv.api.Service.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.Model.BookingDetails;
import com.qldv.api.Model.Ticket;
import com.qldv.api.Repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;
	
	//create tiket
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	//get all ticket
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}
	//get ticket by id
	public Ticket getTicketById(Integer id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket.isPresent()) {
			return ticket.get();
		}
		return new Ticket();
	}
	//update ticket
	public Ticket updateTicket(Integer id, Ticket ticketDetail) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket.isPresent()) {
			Ticket t = ticket.get();
			t.setType(ticketDetail.getType());
			return ticketRepository.save(t);
		}
		return ticketRepository.save(ticketDetail);
	}
	//delete ticket
	public Boolean deleteTicket(Integer id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket.isPresent()) {
			Ticket t = ticket.get();
			List<BookingDetails> books = t.getListBookingDetails();
			for (BookingDetails book : books) {
				book.setTicket(null);
			}
			ticketRepository.delete(t);
			return true;
		}
		return false;
	}
	
}
