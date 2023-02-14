package org.example;

import javax.persistence.*;
import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String [] arg){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            jpaUser user = new jpaUser("user@user.com", "user", LocalDateTime.now());
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        emf.close();
    }
}
