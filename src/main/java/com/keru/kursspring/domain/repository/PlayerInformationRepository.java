package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.PlayerInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerInformationRepository {


    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInfromation(PlayerInformation playerInformation) {
        em.persist(playerInformation);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
