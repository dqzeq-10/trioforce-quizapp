package com.example.finalproject_test.DATA.Models;

import java.sql.Date;

public class ProgressQuestion {
    private String username;
    private int ID_Set;
    private int QuestionCount;
    private int QuestionLastID;
    private Date SaveTime;

    public ProgressQuestion(String username, int ID_Set, int questionCount, int questionLastID, Date saveTime) {
        this.username = username;
        this.ID_Set = ID_Set;
        QuestionCount = questionCount;
        QuestionLastID = questionLastID;
        SaveTime = saveTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID_Set() {
        return ID_Set;
    }

    public void setID_Set(int ID_Set) {
        this.ID_Set = ID_Set;
    }

    public int getQuestionCount() {
        return QuestionCount;
    }

    public void setQuestionCount(int questionCount) {
        QuestionCount = questionCount;
    }

    public int getQuestionLastID() {
        return QuestionLastID;
    }

    public void setQuestionLastID(int questionLastID) {
        QuestionLastID = questionLastID;
    }

    public Date getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(Date saveTime) {
        SaveTime = saveTime;
    }
}
