package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.Client;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.ClientOrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    ClientOrderRepository clientOrderRepository;

    public List<ClientOrder> getOrdersByStatus(int status){
        return clientOrderRepository.getOrderByStatus(status);
    }
    public List<ClientOrder> getOrdersByClient(Client client){
        return clientOrderRepository.getOrderByClient(client);
    }
}
