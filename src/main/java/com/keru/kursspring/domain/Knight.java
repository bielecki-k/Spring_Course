package com.keru.kursspring.domain;

import java.util.Objects;

public class Knight {

    private String name = "Lancelot";
    private int age = 29;
    private Quest quest;

    public Knight() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setQuest(Quest quest) {
        System.out.println("wstrzykniecie questa przez metode");
        this.quest = quest;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "Rycerz o imieniu "+name+" ("+age+") zadanie: "+quest;
    }

}
