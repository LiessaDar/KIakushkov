package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.OrderProduct;
import ru.LiessaDar.telegrambot.entity.OrderProductRepository;
import ru.LiessaDar.telegrambot.entity.Product;

import java.util.List;
import java.util.function.Consumer;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    public List<Product> GetProductsByOrders(List<ClientOrder> orderProductList){
        return orderProductRepository.getProductsByOrderList(orderProductList);
    }
    public List<Product> getMostPopularProducts(Long top){
        return orderProductRepository.getMostPopularProducts().subList(0, top.intValue());
    }
    public List<OrderProduct> getOPListByOrder(ClientOrder clientOrder){
        return orderProductRepository.getPListByOrder(clientOrder);
    }
    public Double countTotal(ClientOrder clientOrder){
        List <OrderProduct> orderProductList = orderProductRepository.getPListByOrder(clientOrder);
        Double summ=0.0;
        for (int i = 0; i < orderProductList.size(); i++) {
            summ += orderProductList.get(i).getCountProduct() * orderProductList.get(i).getProduct().getPrice();
        }
        return summ;
    }
    public String clearOrder(ClientOrder clientOrder){
        orderProductRepository.clearOrder(clientOrder);
        return "Order Successfully cleared";
    }
}
