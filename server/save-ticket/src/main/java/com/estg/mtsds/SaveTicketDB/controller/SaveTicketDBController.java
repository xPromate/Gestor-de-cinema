package com.estg.mtsds.SaveTicketDB.controller;

import com.estg.mtsds.SaveTicketDB.entity.Ticket;
import com.estg.mtsds.SaveTicketDB.service.SaveTicketService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveTicketDBController{

    @Autowired
    private SaveTicketService saveTicketService;

    @RabbitListener(queues = "taketicket-queue")
    public void reservationDetails(String message) {
        Gson g = new Gson();
        Ticket ticket = g.fromJson(message,Ticket.class);

        this.saveTicketService.saveTicket(ticket);
    }
}
