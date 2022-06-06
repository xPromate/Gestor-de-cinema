package com.estg.mtsds.TicketHistory.service;

import com.estg.mtsds.TicketHistory.entity.Ticket;
import com.estg.mtsds.TicketHistory.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketHistoryService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> loadAllTickets(){
        return ticketRepository.findAll() ;
    }
}
