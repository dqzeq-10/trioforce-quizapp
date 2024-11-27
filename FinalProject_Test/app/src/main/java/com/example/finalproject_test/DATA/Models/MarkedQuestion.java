package com.example.finalproject_test.DATA.Models;

import java.sql.Date;

public class MarkedQuestion {
    private String username;
    private int idQuestion;
    private Date markedTime;

    public MarkedQuestion(String username, int idQuestion, Date markedTime) {
        this.username = username;
        this.idQuestion = idQuestion;
        this.markedTime = markedTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Date getMarkedTime() {
        return markedTime;
    }

    public void setMarkedTime(Date markedTime) {
        this.markedTime = markedTime;
    }
}
