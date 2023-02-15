package jpa.main;

import jpa.domain.ActivityLog;
import jpa.jpa.EMFOracle;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;

public class MainSequence {
    private static Logger logger = LoggerFactory.getLogger(MainSequence.class);

    public static void main(String[] args) {
        EMFOracle.init();
        EntityManager em = EMFOracle.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ActivityLog log = new ActivityLog("U01", "VISIT");
            logger.info("persist 실행 전");
            em.persist(log);
            logger.info("persist 실행 함");
            logger.info("생성한 식별자: {}", log.getId());
            logger.info("커밋하기 전");
            tx.commit();
            logger.info("커밋함");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        EMFOracle.close();
    }
}
