package com.michaelwillemse.javaeearquillianbase.rest.producer;

import com.michaelwillemse.javaeearquillianbase.entity.User;
import com.michaelwillemse.javaeearquillianbase.rest.Result;
import com.michaelwillemse.javaeearquillianbase.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Michael on 2/09/2014.
 */

@Path("/users")
@RequestScoped
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/dummy")
    public User getDummy(){
        return new User("dummy", "dummy");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User getUserById(@PathParam("id") long id){
        return userService.getUser(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.createUser(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result delete(@PathParam("id") long id){
        userService.deleteUser(id);
        return new Result("deleted user with id " + id,"ok");
    }
}
