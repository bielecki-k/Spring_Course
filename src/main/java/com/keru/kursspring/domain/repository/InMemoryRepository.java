package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Repository
public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knightsMap = new HashMap<>();

    public InMemoryRepository(){ }

    @Override
    public void createKnight(String name, int age){
        Knight newKnight = new Knight(name,age);
        newKnight.setId(getNewId());
        knightsMap.put(newKnight.getId(), newKnight);
    }

    private int getNewId() {
        if(knightsMap.isEmpty()) return 0;
        else {
             Integer integer = knightsMap.keySet().stream().max(Integer::max).get();
            return integer+1;
        }
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knightsMap.values();
    }

    @Override
    public Optional<Knight> getKnight(String name){
        Optional<Knight> knightByName = knightsMap.values().stream().filter(knigh -> knigh.getName().equals(name)).findAny();
        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id) {
        knightsMap.remove(id);
    }

    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);

    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(getNewId());
        knightsMap.put(knight.getId(),knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knightsMap.get(id);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knightsMap +
                '}';
    }
}
