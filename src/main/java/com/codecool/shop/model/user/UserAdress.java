package com.codecool.shop.model.user;

import java.util.*;

public class UserAdress {
    //  private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer zipCode;
    private Integer creditCardNumber;
    private String nameOnCard;
    private String expiration;
    private Integer cvv;

    public UserAdress(String firstName, String lastName, String country, String city, String street, Integer houseNumber, Integer zipCode, Integer creditCardNumber, String nameOnCard, String expiration, Integer cvv) {
       try{ this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.creditCardNumber = creditCardNumber;
        this.nameOnCard = nameOnCard;
        this.expiration = expiration;
        this.cvv = cvv;
    }catch (NullPointerException e){
           System.out.println("parameters can not be null");
       }
       }

    //ez volna a végleges, csak még nem tudom az id-t elkérni sehonnan
   /* public UserAdress(int id) {
        this.id = id;
    }*/

   /* public int getId() {
        return id;
    }
*/



    public Map<String, String> getBillingFields() {
        Map<String, String> adressMap = new HashMap<>();
        adressMap.put("first_name", firstName);
        adressMap.put("last_name", lastName);
        adressMap.put("country", country);
        adressMap.put("street", street);
        adressMap.put("house_number", String.valueOf(houseNumber));
        adressMap.put("zip_code", String.valueOf(zipCode));
        adressMap.put("credit_card_number",String.valueOf(creditCardNumber) );
        adressMap.put("name_on_card", nameOnCard);
        adressMap.put("expiration", expiration);
        adressMap.put("cvv", String.valueOf(cvv));

        return adressMap;

    }



    public String getFirstName() {
        return firstName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getNameOnCard(){
        return nameOnCard;
    }

    @Override
    public String toString(){
        return String.format("Name: %s %s\n" +
                "country: %s, credit card number: %d", firstName, lastName, country, creditCardNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAdress that = (UserAdress) o;
        return houseNumber == that.houseNumber && zipCode == that.zipCode && creditCardNumber == that.creditCardNumber && cvv == that.cvv && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(nameOnCard, that.nameOnCard) && Objects.equals(expiration, that.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country, city, street, houseNumber, zipCode, creditCardNumber, nameOnCard, expiration, cvv);
    }
}

