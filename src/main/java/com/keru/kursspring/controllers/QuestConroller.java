package com.keru.kursspring.controllers;

import com.keru.kursspring.domain.Knight;
import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.services.KnightService;
import com.keru.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestConroller {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @RequestMapping("/assignQuest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model){
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNoitStartedQuests();
        return "assignQuest";
    }
}
