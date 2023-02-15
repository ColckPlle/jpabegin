package jpa.main;

import jpa.domain.Grade;
import jpa.domain.Hotel;
import org.example.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainNullEmbedded {
    private static Logger logger = LoggerFactory.getLogger(MainNullEmbedded.class);

    public static void main(String[] args) {
        EMF.init();
        saveHotel();
        printHotel();
        EMF.close();
    }

    private static void saveHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(
                    new Hotel("H009", "HN", 2022, Grade.S7, null)
            );
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    private static void printHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H009");
            if (hotel != null) {
                logger.info("주소: {}", hotel.getAddress());
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
