package com.michaelwillemse.javaeearquillianbase.rest;

import com.jayway.restassured.http.ContentType;
import com.michaelwillemse.javaeearquillianbase.entity.User;
import com.michaelwillemse.javaeearquillianbase.service.UserService;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URL;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created by Michael on 2/09/2014.
 */

@RunWith(Arquillian.class)
public class UserResourceTest {

    @ArquillianResource
    private URL deploymentUrl;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(User.class, UserService.class)
                .addPackages(true, UserApplication.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test @RunAsClient
     public void getDummy(){
        given()
        .expect()
                .contentType(ContentType.JSON)
        .when()
                .get(buildUri("users", "dummy"))
                .as(User.class);
    }

    @Test @RunAsClient
    public void getUsers(){
        User user = new User("Mark Doe", "mark@doe.com");
        given()
                .body(user).contentType(ContentType.JSON)
        .expect()
                .contentType(ContentType.JSON)
        .when()
                .post(buildUri("users"))
                .as(User.class);

        User returnUser =
        given()
        .expect()
                .contentType(ContentType.JSON)
        .when()
                .get(buildUri("users"))
                .as(User[].class)[0];

        Assert.assertEquals(returnUser.getName(), user.getName());
    }

    URI buildUri(String... paths) {
        UriBuilder builder = UriBuilder.fromUri(deploymentUrl.toString());
        for (String path : paths) {
            builder.path(path);
        }
        return builder.build();
    }

}
