package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepository {

    List<Quest> questList = new ArrayList<>();

    final static Random rand = new Random();

    public void createQuest(String description){
        questList.add(new Quest(description));
    }

    public List<Quest> getQuestList() {
        return questList;
    }

    public void removeQuest(Quest quest){
        questList.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest(){
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Override
    public String toString() { return "QuestRepository{" + "questList=" + questList + '}'; }
}
