package com.keru.kursspring.domain;

import org.junit.jupiter.api.Test;

public class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted(){
        Knight knight = new Knight("Percival", 25);
        Quest quest = new Quest("testowy quest");

        knight.setQuest(quest);

        assert(knight.getQuest().isStarted());
    }
}
