package com.alianza.customerManagement.controller;

import com.alianza.customerManagement.model.Client;
import com.alianza.customerManagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{sharedKey}")
    public Client searchClientBySharedKey(@PathVariable String sharedKey) {
        return clientService.searchClientBySharedKey(sharedKey);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}
