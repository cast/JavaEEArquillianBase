package com.michaelwillemse.javaeearquillianbase.rest;

import com.michaelwillemse.javaeearquillianbase.rest.producer.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michael on 2/09/2014.
 */

@ApplicationPath("/")
public class UserApplication extends Application {
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(UserResource.class);
        return s;
    }
}
