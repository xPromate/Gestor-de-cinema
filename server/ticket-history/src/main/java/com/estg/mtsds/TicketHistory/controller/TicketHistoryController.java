package com.estg.mtsds.TicketHistory.controller;

import com.estg.mtsds.TicketHistory.entity.Ticket;
import com.estg.mtsds.TicketHistory.service.TicketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticketHistory")
public class TicketHistoryController {

    @Autowired
    private TicketHistoryService ticketHistoryService;

    @GetMapping("/getAllTickets")
    private List<Ticket> getAllTickets() {
        return this.ticketHistoryService.loadAllTickets();
    }
}
