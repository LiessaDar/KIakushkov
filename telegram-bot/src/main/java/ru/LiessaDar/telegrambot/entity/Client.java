package ru.LiessaDar.telegrambot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "externalId", nullable = false,unique = true)
    private Long externalId;

    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;

    @Column(name = "phoneNumber", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "address", nullable = false, length = 400)
    private String address;

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

