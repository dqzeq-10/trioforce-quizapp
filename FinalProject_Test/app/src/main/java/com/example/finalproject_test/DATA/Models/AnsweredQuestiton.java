package com.example.finalproject_test.DATA.Models;

public class AnsweredQuestiton {
    private String username;
    private int idSet;
    private int idQuestion;
    private boolean isCorrect;

    public AnsweredQuestiton(String username, int idSet, int idQuestion, boolean isCorrect) {
        this.username = username;
        this.idSet = idSet;
        this.idQuestion = idQuestion;
        this.isCorrect = isCorrect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdSet() {
        return idSet;
    }

    public void setIdSet(int idSet) {
        this.idSet = idSet;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
