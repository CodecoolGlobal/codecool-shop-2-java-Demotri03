package com.codecool.shop.model.user;

public class UserAdress {
    private int id;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private int zipCode;

    public UserAdress(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAdressFields(String country, String city, String street, int houseNumber, int zipCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }
}

