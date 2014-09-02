package com.michaelwillemse.javaeearquillianbase.service;

import com.michaelwillemse.javaeearquillianbase.entity.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by Michael on 2/09/2014.
 */

@RunWith(Arquillian.class)
public class UserServiceTest {
    @Inject
    UserService userService;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(User.class, UserService.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test
    public void createTest(){
        User user = new User("Jane Doe", "jane@doe.com");
        user = userService.createUser(user);
        User queriedUser = userService.getUserByName("Jane Doe");
        Assert.assertEquals(user.getId(), queriedUser.getId());
        Assert.assertEquals(user.getName(), queriedUser.getName());
    }
}
