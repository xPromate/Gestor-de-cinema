package com.estg.mtsds.SaveTicketDB.repository;

import com.estg.mtsds.SaveTicketDB.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket,String> {
}
