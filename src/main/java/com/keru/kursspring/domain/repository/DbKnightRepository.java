package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

//@Repository
public class DbKnightRepository implements KnightRepository{
    @Override
    public void createKnight(String name, int age) {

        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    public Knight getKnightById(Integer id) {
        return null;
    }

    @Override
    public String toString() {
        return "DbKnightRepository{}";
    }
}
