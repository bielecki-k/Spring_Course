package com.keru.kursspring.domain;

import java.util.Objects;

public class Knight {

    private String name ;
    private int age ;
    private int id ;
    private Quest quest;
    private int level;


    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString(){
        return "Rycerz o imieniu "+name+" ("+age+") zadanie: "+quest;
    }

    public void setQuest(Quest quest) {
        System.out.println("wstrzykniecie questa przez metode");
        this.quest = quest;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public int getId() { return id;    }
    public void setId(int id) { this.id = id;    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() { return level;    }

    public void setLevel(int level) {  this.level = level;    }

}
