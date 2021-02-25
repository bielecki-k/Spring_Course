package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {

    Map<Integer,Quest> quests = new HashMap<>();

    Random rand = new Random();

    public void createQuest(String description){
        int newId = Ids.getNewId(quests.keySet());
        Quest newQuest = new Quest(newId,description);
        quests.put(newId,newQuest);
    }

    public List<Quest> getQuestList() {
        return new ArrayList<>(quests.values());
    }

    public void removeQuest(Quest quest){
        quests.remove(quest.getId());
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
    public String toString() { return "QuestRepository{" + "quests=" + quests + '}'; }

    public void update(Quest quest) {
        quests.put(quest.getId(),quest);
    }

    public Quest getQuests(Integer id) {
        return quests.get(id);
//        return quests;
    }

//    public void setQuests(Map<Integer, Quest> quests) { this.quests = quests; }
}
