package com.example.finalproject_test.DATA.Models;

import java.sql.Date;

public class MarkedQuestion {
    private String username;
    private int ID_Question;
    private Date MarkedTime;

    public MarkedQuestion(String username, int ID_Question, Date markedTime) {
        this.username = username;
        this.ID_Question = ID_Question;
        MarkedTime = markedTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID_Question() {
        return ID_Question;
    }

    public void setID_Question(int ID_Question) {
        this.ID_Question = ID_Question;
    }

    public Date getMarkedTime() {
        return MarkedTime;
    }

    public void setMarkedTime(Date markedTime) {
        MarkedTime = markedTime;
    }
}
