package com.keru.kursspring.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class RoleRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void persistRole(Role role) {
        em.persist(role);
    }

    public List<Role> getAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }
}
