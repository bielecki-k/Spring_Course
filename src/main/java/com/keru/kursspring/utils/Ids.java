package com.keru.kursspring.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {

    static public int getNewId(Set<Integer> keys) {
        if(keys.isEmpty()) return 0;
        else {
            Integer integer = keys.stream().max(Comparator.naturalOrder()).get();
            return integer+1;
        }
    }
}
