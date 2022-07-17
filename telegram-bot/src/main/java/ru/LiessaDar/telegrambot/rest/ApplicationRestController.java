package ru.LiessaDar.telegrambot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.LiessaDar.telegrambot.entity.Client;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.OrderProduct;
import ru.LiessaDar.telegrambot.entity.Product;
import ru.LiessaDar.telegrambot.service.*;

import java.util.List;
@RestController
public class ApplicationRestController {
    @Autowired
    private  ClientService clientService;
    @Autowired
    private  ProductAndCategoryService productAndCategoryService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private TelegramBotApplicationService telegramBotApplicationService;

//For Client Info
    @GetMapping( value = "/rest/clients",params = {"name"})
    public Client clientInfo(String name){
        return clientService.getClientByName(name);
    }
//For Orders info
    @GetMapping( value = "/rest/orders",params = {"status"})
    public List<ClientOrder> orderInfo(int status){
        return orderService.getOrdersByStatus(status);
    }
//For Product Info
    @GetMapping( value = "/rest/products",params = {"name"})
    public Product productInfo(String name){
        return productAndCategoryService.getProductInfo(name);
    }
//For Products with Category list
    @GetMapping(value = "/rest/products",params = {"categoryId"})
        public List<Product> productList(Long categoryId){
            return productAndCategoryService.getProductsByCategory(categoryId);
    }
//For Orders by Client Name
    @GetMapping( value = "/rest/listClientOrders",params = {"clientName"})
    public List<ClientOrder> clientsOrders(String clientName){
        return orderService.getOrdersByClient(clientService.getClientByName(clientName));
    }
//For Orders by Client Name
    @GetMapping( value = "/rest/listClientProducts",params = {"clientId"})
    public List<Product> clientsProducts(Long clientId){
        return  orderProductService.GetProductsByOrders(orderService.getOrdersByClient(clientService.getClientById(clientId)));
    }
//For top most popular products
    @GetMapping( value = "/rest/topPopularProducts",params = {"top"})
    public List<Product> topProducts(Long top){
        return orderProductService.getMostPopularProducts(top);
    }
//Features for task 4
    @GetMapping (value = "/rest/clientStart",params = {"externalId"})
    public Client clientStart(Long externalId){
        Client client =telegramBotApplicationService.clientRegistration(externalId);
  /*      if (client==null){
            String name="";
            String phoneNumber = "";
            String adress = "";
            //data request
            client= telegramBotApplicationService.newClientRegistration(externalId,name,adress,phoneNumber);
        }*/
        return client;
    }
    @GetMapping(value = "/rest/test",params = {"externalId"})
    public ClientOrder orderStart(Long externalId){
        return telegramBotApplicationService.openClientOrderSession(telegramBotApplicationService.clientRegistration(externalId));
    }
    @GetMapping(value = "/rest/testTotal",params = {"externalId"})
    public ClientOrder orderCountTotal(Long externalId){
        return telegramBotApplicationService.orderCountTotal(externalId);
    }
    @GetMapping(value = "/rest/testadd",params = {"externalId"," ","count"})
    public OrderProduct addOP(Long externalId, String productName, Long count){
        return telegramBotApplicationService.addOP(externalId,productName,count);
    }

}
