package org.example.service;

import org.example.EMF;
import org.example.User;

import javax.persistence.EntityManager;

public class GetUserService {
    public User getUser(String email){
        EntityManager em = EMF.createEntityManager();
        try{
            User user = em.find(User.class, email);
            if(user ==null) {
                throw new IllegalStateException();
            }
            return user;
        } finally {
            em.close();
        }
    }
}
