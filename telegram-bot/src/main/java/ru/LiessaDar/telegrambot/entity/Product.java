package ru.LiessaDar.telegrambot.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

    @Column(name = "name", nullable = false, length = 50,unique = true)
    private String name;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @Column(name = "price", nullable = false,  precision=15, scale=2)
    private Double price;

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
