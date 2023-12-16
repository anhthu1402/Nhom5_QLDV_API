package com.qldv.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qldv.api.Model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
