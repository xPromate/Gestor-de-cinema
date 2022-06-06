package com.estg.mtsds.TakeTicket.controller;


import com.estg.mtsds.TakeTicket.model.Ticket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tickets")
public class TakeTicketController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @CrossOrigin
    @PostMapping("/takeTicket")
    public void makePayment(@RequestBody Ticket ticket){
        System.out.println(ticket.toString());

        try {
            ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
            String json = ow.writeValueAsString(ticket);
            System.out.println(json);

            this.rabbitTemplate.convertAndSend("directExchange", "taketicket-key", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}
