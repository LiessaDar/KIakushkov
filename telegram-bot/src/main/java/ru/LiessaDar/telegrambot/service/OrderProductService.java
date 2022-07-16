package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.OrderProduct;
import ru.LiessaDar.telegrambot.entity.OrderProductRepository;
import ru.LiessaDar.telegrambot.entity.Product;

import java.util.List;

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
}
