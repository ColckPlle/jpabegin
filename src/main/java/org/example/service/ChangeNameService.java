package org.example.service;

import org.example.EMF;
import org.example.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

public class ChangeNameService {
    public void changeName(String email, String newname){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            User user = em.find(User.class, email);
            if(user ==null) {
                throw new IllegalStateException();
            }
            user.changeName(newname);
        } catch (Exception ex){
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}