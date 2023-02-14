package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class UserGetMain {
    public static void main(String [] arg){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            User user = entityManager.find(User.class, "user@user.com");
            if( user == null){
                System.out.println("유저 없음");
            } else {
                System.out.println("유저 있음");
            }
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
