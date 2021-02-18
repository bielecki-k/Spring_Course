package com.keru.kursspring.domain;

public class Quest {

    private String desc;
    private int reward = 100;
    private int lenght = 30000;
    private boolean started = false;
    private boolean completed = false;
    private int id;

    public Quest(String desc) {
        this.desc=desc;
    }

    public Quest(int id, String description) {
        this.id = id;
        this.desc = description;
    }


    @Override
    public String toString() {
        return desc;
    }


    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public int getReward() { return reward; }
    public void setReward(int reward) { this.reward = reward; }

    public int getLenght() { return lenght;  }
    public void setLenght(int lenght) { this.lenght = lenght;  }

    public boolean isStarted() { return started; }
    public void setStarted(boolean started) { this.started = started; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public int getId() { return id;  }
    public void setId(int id) { this.id = id; }
}
