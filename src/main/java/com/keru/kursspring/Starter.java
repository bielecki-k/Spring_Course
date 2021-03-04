package com.keru.kursspring;

import com.keru.kursspring.domain.PlayerInformation;
import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.repository.KnightRepository;
import com.keru.kursspring.domain.repository.PlayerInformationRepository;
import com.keru.kursspring.domain.repository.QuestRepository;
import com.keru.kursspring.services.QuestService;
import com.keru.kursspring.utils.Role;
import com.keru.kursspring.utils.RoleRepository;
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
    PlayerInformationRepository playerInformationRepo;

    @Autowired
    QuestService questService;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",32);

        PlayerInformation playerInformation1 = new PlayerInformation("user1","user1");
        playerInformationRepo.createPlayerInfromation(playerInformation1);
        PlayerInformation playerInformation2 = new PlayerInformation("user2","user2");
        playerInformationRepo.createPlayerInfromation(playerInformation2);

        Role user1RoleUSER = new Role("user1","USER");
        Role user2RoleUSER = new Role("user2","USER");
        Role user2RoleADMIN = new Role("user2","ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);

        questService.assignRandomQuest("Percival");

        System.out.println(roleRepository.getAll());


    }
}
