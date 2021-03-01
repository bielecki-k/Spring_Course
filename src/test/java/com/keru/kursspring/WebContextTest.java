package com.keru.kursspring;

import com.keru.kursspring.controllers.QuestConroller;
import com.keru.kursspring.domain.Knight;
import com.keru.kursspring.domain.PlayerInformation;
import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.services.KnightService;
import com.keru.kursspring.services.QuestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WebContextTest {

    @Mock
    KnightService knightService;
    @Mock
    QuestService questService;
    @Mock
    PlayerInformation playerInformation;
    @InjectMocks
    QuestConroller questConroller;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(questConroller).build();
    }

    @Test
    public void testCheckQuest() throws Exception {
//        Quest quest = new Quest(0,"zadanie etst");
//        Knight percival = new Knight("Percival",33);
//        Knight percival2 = new Knight("Percival2",34);
//        percival.setQuest(quest);
//        List<Knight> knights = new ArrayList<>(2);
//        knights.add(percival);
//        knights.add(percival2);
//
//        when(knightService.getAllKnights()).thenReturn(knights);

        mockMvc.perform(get("/checkQuests"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {
    }



}
