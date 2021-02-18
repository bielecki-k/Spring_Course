package com.keru.kursspring.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {

    @Test
    public void testEmptySet(){
        int result = Ids.getNewId(Collections.emptySet());
        Assertions.assertEquals(0,result);
    }

    @Test
    public void testGeNewId(){
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        int result = Ids.getNewId(sample);
        Assertions.assertEquals(7,result);
    }
}
