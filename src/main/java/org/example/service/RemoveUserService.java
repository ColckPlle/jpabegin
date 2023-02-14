package org.example.service;

import org.example.EMF;
import org.example.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RemoveUserService {
    public void removeUser(String email){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            User user = em.find(User.class, email);
            if(user == null){
                throw new IllegalStateException();
            }
            em.remove(user);
            tx.commit();
        } catch(Exception ex){
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
