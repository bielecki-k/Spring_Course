package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Knight;
import com.keru.kursspring.utils.Ids;

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
        newKnight.setId(Ids.getNewId(knightsMap.keySet()));
        knightsMap.put(newKnight.getId(), newKnight);
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
    public void updateKnight(int id, Knight knight){
        knightsMap.put(id,knight);
    }

    @Override
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);

    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Ids.getNewId(knightsMap.keySet()));
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
