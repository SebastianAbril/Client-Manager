package com.sebastianabril.clientManager.service;

import com.sebastianabril.clientManager.model.Client;
import com.sebastianabril.clientManager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(String name, String lastname, String phoneNumber, String email, String company, String country, String city){

        Client client = new Client();
        client.setName(name);
        client.setLastname(lastname);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        client.setCompany(company);
        client.setCity(city);
        client.setCountry(country);

        clientRepository.save(client);
    }

    public List<Client> getClients(){
        return clientRepository.findByOrderByIdAsc();
    }

    public Client getClientById(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new RuntimeException("The Client with the requested Id does not exists.");
        }
        return optionalClient.get();
    }
}
