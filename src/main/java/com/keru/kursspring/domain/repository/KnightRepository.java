package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();


    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);
    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight){
        throw new UnsupportedOperationException();
    }
}
