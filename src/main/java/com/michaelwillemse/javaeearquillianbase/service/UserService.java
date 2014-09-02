package com.michaelwillemse.javaeearquillianbase.service;

import com.michaelwillemse.javaeearquillianbase.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Michael on 2/09/2014.
 */

@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;

    public User createUser(User user){
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    public void deleteUser(User user){
        entityManager.remove(user);
    }

    public void deleteUser(long id){
        User user = new User();
        user.setId(id);
        deleteUser(user);
    }

    public User getUser(long id){
        return entityManager.find(User.class, id);
    }

    public List<User> getUsers(){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public User getUserByName(String name){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class).setParameter("name", name);
        return query.getResultList().get(0);
    }

    public User getUserByEmail(String email){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class).setParameter("email", email);
        return query.getResultList().get(0);
    }
}
