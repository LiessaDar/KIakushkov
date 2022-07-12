package ru.LiessaDar.telegrambot.entity;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, length = 50,unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name="parent", nullable=true)
    private Category parent;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
