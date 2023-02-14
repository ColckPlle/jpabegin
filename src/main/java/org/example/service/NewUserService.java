package org.example.service;

import org.example.EMF;
import org.example.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class NewUserService {
    public void saveNewUser (User user){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx =em.getTransaction();

        try{
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch (Exception ex){
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
