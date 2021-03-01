package com.keru.kursspring.services;

import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.domain.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

public class QuestServiceTests {

    @Mock
    private QuestRepository repositoryMock;

    @Test
    public void emptyTest() {
    }

    @Test
    public void returnsNotStartedTests(){
        List<Quest> questsList = new ArrayList<>();
        Quest q1 = new Quest(1, "Test quest 1");
        Quest q2 = new Quest(2, "Test quest 2");
        Quest q3 = new Quest(3, "Test quest 3");

        q2.setStarted(true);

        questsList.add(q1);
        questsList.add(q2);
        questsList.add(q3);

        when(repositoryMock.getQuestList()).thenReturn(questsList);

        QuestService questService = new QuestService();
        questService.setQuestRepository(repositoryMock);

        List<Quest> allNoitStartedQuests = questService.getAllNotStartedQuests();
        assertEquals("size of return quest",2,allNoitStartedQuests.size());
    }
}
