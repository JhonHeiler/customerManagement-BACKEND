package com.alianza.customerManagement.service;

import com.alianza.customerManagement.model.Client;
import com.alianza.customerManagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        generateSharedKey(client);
        return clientRepository.save(client);
    }

    public Client searchClientBySharedKey(String sharedKey) {
        return clientRepository.findBySharedKey(sharedKey);
    }

    private void generateSharedKey(Client client) {
        String name = client.getName();
        String sharedKey = generateUniqueSharedKey(name);
        client.setSharedKey(sharedKey);
    }

    private String generateUniqueSharedKey(String name) {
        String uniqueKey = name.replaceAll("\\s+", "").toLowerCase();
        uniqueKey += "-" + UUID.randomUUID().toString().replaceAll("-", "");
        return uniqueKey;
    }
}
