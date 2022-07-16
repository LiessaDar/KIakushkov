package ru.LiessaDar.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.LiessaDar.telegrambot.entity.CategoryRepository;
import ru.LiessaDar.telegrambot.entity.ClientOrder;
import ru.LiessaDar.telegrambot.entity.Product;
import ru.LiessaDar.telegrambot.entity.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductAndCategoryService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product getProductInfo(String productName){
        Product exampleProduct = new Product();
        exampleProduct.setName(productName);
        return productRepository.findOne(Example.of(exampleProduct)).orElse(null);
    }
    public List<Product> getProductsByCategory(Long categoryID){
        return productRepository.getProductsByListID(categoryRepository.categoryListByParent(categoryID));
    }
}
