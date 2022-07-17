package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.Client;
import ru.LiessaDar.telegrambot.entity.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client getClientByName(String name){
        Client exampleClient = new Client();
        exampleClient.setFullName(name);
        return clientRepository.findOne(Example.of(exampleClient)).orElse(null);
    }
    public Client getClientById(Long clientId){
        Client exampleClient = new Client();
        exampleClient.setId(clientId);
        return clientRepository.findOne(Example.of(exampleClient)).orElse(null);
    }
    public Client getClientByExstId(Long externalId){
        Client exampleClient = new Client();
        exampleClient.setExternalId(externalId);
        return clientRepository.findOne(Example.of(exampleClient)).orElse(null);
    }
    public Client createNewClient(Long externalId,String name,String adress,String phoneNumber){
        Client client = new Client();
        client.setAddress(adress);
        client.setExternalId(externalId);
        client.setFullName(name);
        client.setPhoneNumber(phoneNumber);
        clientRepository.save(client);
        return client;
    }

}
