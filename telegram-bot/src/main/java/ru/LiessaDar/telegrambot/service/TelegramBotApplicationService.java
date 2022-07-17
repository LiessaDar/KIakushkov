package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.Client;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
@Service
public class TelegramBotApplicationService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductAndCategoryService productAndCategoryService;

    public Client clientRegistration(Long externalId){
        Client client=clientService.getClientByExstId(externalId);
        if (client !=null){
            return client;
        }else{
            //запросить данные у пользователя!!!!
            String name="";
            String adress="";
            String phoneNumber="";
            client=clientService.createNewClient(externalId,name,adress,phoneNumber);
            return client;
        }
    }

    public ClientOrder openClientOrderSession(Client client){
        ClientOrder clientOrder=orderService.findNotClosedOrderByClient(client);
        if (clientOrder!=null){
            return clientOrder;
        } else {
            return orderService.createOrder(client);
        }
    }
}
