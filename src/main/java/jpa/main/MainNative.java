package jpa.main;

import jpa.domain.Review;
import jpa.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainNative {
    private static Logger logger = LoggerFactory.getLogger(MainNative.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Review review = new Review(5, "H-01", "작성자", "댓글");
            logger.info("persist 실행 전");
            em.persist(review);
            logger.info("persist 실행 함");
            logger.info("생성한 식별자: {}", review.getId());
            logger.info("커밋하기 전");
            tx.commit();
            logger.info("커밋함");
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        EMF.close();
    }
}

