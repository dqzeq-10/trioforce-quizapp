package com.example.finalproject_test.DATA.Models;

public class AnsweredQuestiton {
    private String username;
    private int ID_Set;
    private int ID_Question;
    private boolean isCorrect;

    public AnsweredQuestiton(String username, int ID_Set, int ID_Question, boolean isCorrect) {
        this.username = username;
        this.ID_Set = ID_Set;
        this.ID_Question = ID_Question;
        this.isCorrect = isCorrect;
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

    public int getID_Question() {
        return ID_Question;
    }

    public void setID_Question(int ID_Question) {
        this.ID_Question = ID_Question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
