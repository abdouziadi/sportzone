package com.example.sportzone.RestController;

import com.example.sportzone.Services.ClientService;
import com.example.sportzone.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/getOne/{id}")
    public Client getClientById(@PathVariable long id) {
        return clientService.getClientById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client) {
        Client existingClient = clientService.getClientById(id).orElse(null);

        if (existingClient != null) {
            client.setId(id);
            return clientService.updateClient(client);
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }
}
