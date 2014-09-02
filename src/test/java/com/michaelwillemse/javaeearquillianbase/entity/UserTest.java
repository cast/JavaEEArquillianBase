package com.michaelwillemse.javaeearquillianbase.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Michael on 2/09/2014.
 */
public class UserTest {
    @Test
    public void testUser(){
        User user = new User("John Doe", "john@doe.com");
        Assert.assertEquals(user.getName(), "John Doe");
    }
}
