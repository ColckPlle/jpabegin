package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EMF {

    private static EntityManagerFactory emf;

    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpabegin");
    }

    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }
}
