package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Quest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class QuestRepository {

    Random rand = new Random();
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createQuest(String description){
        Quest newQuest = new Quest(description);
        em.persist(newQuest);
    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest",Quest.class).getResultList();
    }

    @Transactional
    public void removeQuest(Quest quest){
        em.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        em.merge(quest);
    }

    public Quest getQuests(Integer id) {
        return em.find(Quest.class,id);
    }

}
