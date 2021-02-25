package com.keru.kursspring.controllers;

import com.keru.kursspring.domain.Knight;
import com.keru.kursspring.domain.PlayerInformation;
import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.services.KnightService;
import com.keru.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestConroller {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignQuest";
    }

    @RequestMapping(value = "/assignQuest", method = RequestMethod.POST)
    public String assignQuest(Knight knight, BindingResult result) {
        System.out.println(result);
        knightService.updateKnight(knight);
//        Quest quest = knight.getQuest();
//        questService.update(quest);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuests")
    public String checkQuests() {

        List<Knight> allKnights = knightService.getAllKnights();
        allKnights.forEach(knight -> knight.getQuest().isCompleted());

        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + knightService.collectRewards());
        return "redirect:/knights";
    }
}
