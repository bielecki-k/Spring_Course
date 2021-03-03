package com.keru.kursspring;

import com.keru.kursspring.domain.PlayerInformation;
import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.repository.KnightRepository;
import com.keru.kursspring.domain.repository.QuestRepository;
import com.keru.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    QuestService questService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",32);


        questService.assignRandomQuest("Percival");


    }
}
