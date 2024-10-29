package com.example.sportzone.Services;

import com.example.sportzone.Repository.ClientRepository;
import com.example.sportzone.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }
}
