package jpa.main;

import jpa.domain.Address;
import jpa.domain.Grade;
import jpa.domain.Hotel;
import org.example.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainEmbeddable {
    private static Logger logger = LoggerFactory.getLogger(MainEmbeddable.class);

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
            Address address = new Address("주소1", "주소2", "12345");
            Hotel hotel = new Hotel("H00", "HN", 2022, Grade.S7, address);
            em.persist(hotel);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void printHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H00");
            if (hotel != null) {
                logger.info("주소: {}", hotel.getAddress());
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
