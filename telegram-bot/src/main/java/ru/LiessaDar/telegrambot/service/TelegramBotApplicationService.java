package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.Client;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.OrderProduct;
import ru.LiessaDar.telegrambot.entity.Product;

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
        return clientService.getClientByExstId(externalId);
    }
    public Client newClientRegistration(Long externalId,String name,String adress,String phoneNumber){
        return clientService.createNewClient(externalId,name,adress,phoneNumber);
    }

    public ClientOrder openClientOrderSession(Client client){
        ClientOrder clientOrder=orderService.findNotClosedOrderByClient(client);
        if (clientOrder!=null){
            return clientOrder;
        } else {
            return orderService.createOrder(client);
        }
    }
    public  ClientOrder orderCountTotal(Long externalId){
       Client client = clientService.getClientByExstId(externalId);
       ClientOrder clientOrder = orderService.findNotClosedOrderByClient(client);
       Double total = orderProductService.countTotal(clientOrder);
        return orderService.updateOrderTotal(clientOrder,total);
    }
    public OrderProduct addOP(Long externalId,String productName,Long count){
        Product product = productAndCategoryService.getProductInfo(productName);
        ClientOrder clientOrder = orderService.findNotClosedOrderByClient(clientService.getClientByExstId(externalId));
        return  orderProductService.addOPtoBase(clientOrder,product,count);
    }
}
