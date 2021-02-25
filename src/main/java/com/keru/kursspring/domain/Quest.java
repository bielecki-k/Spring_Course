package com.keru.kursspring.domain;

import java.time.LocalDateTime;

public class Quest {

    private String desc;
    private int reward = 100;
    private int lenght = 30000;
    protected int lenghtInSeconds = 10;
    private boolean started = false;
    private boolean completed = false;
    private int id;
    protected LocalDateTime startDate;


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
    public void setStarted(boolean started) {
        if(started) this.startDate = LocalDateTime.now();
        this.started = started;
    }

    public boolean isCompleted() {

        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);
            boolean isAfter = now.isAfter(questEndDate);
            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public int getId() { return id;  }
    public void setId(int id) { this.id = id; }




}
