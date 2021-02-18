package com.keru.kursspring.services;

import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.repository.KnightRepository;
import com.keru.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepository.getQuestList();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName)
                .ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.removeQuest(randomQuest);
    }


    public List<Quest> getAllNoitStartedQuests() {
        return questRepository.getQuestList().stream()
                .filter(quest -> !quest.isStarted())
                .collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }
}
