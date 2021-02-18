package com.keru.kursspring.domain.repository;

import com.keru.kursspring.domain.Knight;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

import javax.annotation.PostConstruct;
import java.util.Collection;

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
    public Knight getKnight(String name) {
        System.out.println("uzywam bazy danych");
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteKnight(String name) {
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
    public String toString() {
        return "DbKnightRepository{}";
    }
}
