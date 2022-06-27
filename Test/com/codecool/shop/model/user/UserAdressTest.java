package com.codecool.shop.model.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAdressTest {

    public String testStr;
    public int testInt;

    @Test
    void testUserAdressFieldsValidParameters() {
        createParameters();
        UserAdress testUserAdress = new UserAdress(testStr, testStr, testStr, testStr, testStr, testInt, testInt, testInt, testStr, testStr, testInt);
        assertEquals(123, testUserAdress.getHouseNumber());
        assertEquals("abc", testUserAdress.getFirstName());
    }

    @Test
    void testUserAdressForSomeNullValues() {
        createParameters();
        UserAdress testUserAdress = new UserAdress(testStr, testStr, null, testStr, testStr, null, testInt, testInt, testStr, testStr, testInt);
        assertEquals("abc", testUserAdress.getFirstName());
        assertNull(testUserAdress.getHouseNumber());
        assertEquals("abc", testUserAdress.getNameOnCard());

    }

    public void createParameters() {
        testInt = 123;
        testStr = "abc";
    }


}