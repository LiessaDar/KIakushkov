package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;

public class TelegramBotApplicationService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductAndCategoryService productAndCategoryService;

}
