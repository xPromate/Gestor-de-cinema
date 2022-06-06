package com.estg.mtsds.TicketHistory.repository;

import com.estg.mtsds.TicketHistory.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket,String> {
}
