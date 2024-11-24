package com.example.finalproject_test.DATA.Models;

import java.sql.Date;

public class CreatedQuestion {
    private String username;
    private int ID_Question;
    private Date CreatedTime;

    public CreatedQuestion(String username, int ID_Question, Date createdTime) {
        this.username = username;
        this.ID_Question = ID_Question;
        CreatedTime = createdTime;
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

    public Date getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(Date createdTime) {
        CreatedTime = createdTime;
    }
}
