package com.qldv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qldv.api.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
