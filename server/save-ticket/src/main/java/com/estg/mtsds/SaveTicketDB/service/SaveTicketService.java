package com.estg.mtsds.SaveTicketDB.service;

import com.estg.mtsds.SaveTicketDB.entity.Ticket;
import com.estg.mtsds.SaveTicketDB.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveTicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
