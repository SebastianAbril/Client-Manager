package com.sebastianabril.clientManager.controller;

import com.sebastianabril.clientManager.model.Client;
import com.sebastianabril.clientManager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public void createClient(@RequestBody Client client){
        String name = client.getName();
        String lastname = client.getLastname();
        String phoneNumber = client.getPhoneNumber();
        String email = client.getEmail();
        String company = client.getCompany();
        String city = client.getCity();
        String country = client.getCountry();

        clientService.createClient(name, lastname, phoneNumber, email, company, city, country);
    }

    @GetMapping("/client")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

}
