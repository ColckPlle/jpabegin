package jpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFOracle {
    private static EntityManagerFactory emf;

    public static void init() {
        emf = Persistence.createEntityManagerFactory("oracle");
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
