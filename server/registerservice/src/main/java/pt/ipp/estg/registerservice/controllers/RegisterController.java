package pt.ipp.estg.registerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipp.estg.registerservice.models.Client;
import pt.ipp.estg.registerservice.repositories.ClientRepository;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    ClientRepository clientRepo;

    @PostMapping("/newClient")
    public String addClient(@RequestBody Client client) {
        Client c = new Client(client.getName(), client.getPassword(), client.getNif(), client.getEmail(), client.getCellphone());
        clientRepo.save(c);

        return "Client registered successfully";
    }
}
