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
public ClientOrder createOrder(Client client){
       ClientOrder cOrder = new ClientOrder();
       cOrder.setClient(client);
       cOrder.setStatus(1);
       clientOrderRepository.save(cOrder);
       return cOrder;
}
public ClientOrder findNotClosedOrderByClient(Client client){
    ClientOrder exampleClientOrder = new ClientOrder();
    exampleClientOrder.setClient(client);
    exampleClientOrder.setStatus(1);
    return clientOrderRepository.findOne(Example.of(exampleClientOrder)).orElse(null);
}
}
