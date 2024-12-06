package com.example.finalproject_test.DATA.Models;

import java.io.Serializable;

public class AnsweredQuestion implements Serializable {
    private String username;
    private int idSet;
    private int idQuestion;
    private boolean isCorrectChoice;

    private Question idQuestionNavigation;
    private QuestionSet idSetNavigation;
    private User usernameNavigation;



    public AnsweredQuestion(String username, int idSet, int idQuestion, boolean isCorrect) {
        this.username = username;
        this.idSet = idSet;
        this.idQuestion = idQuestion;
        this.isCorrectChoice = isCorrect;
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

    public boolean isCorrectChoice() {
        return isCorrectChoice;
    }

    public void setCorrectChoice(boolean correctChoice) {
        isCorrectChoice = correctChoice;
    }

    public Question getIdQuestionNavigation() {
        return idQuestionNavigation;
    }

    public void setIdQuestionNavigation(Question idQuestionNavigation) {
        this.idQuestionNavigation = idQuestionNavigation;
    }

    public QuestionSet getIdSetNavigation() {
        return idSetNavigation;
    }

    public void setIdSetNavigation(QuestionSet idSetNavigation) {
        this.idSetNavigation = idSetNavigation;
    }

    public User getUsernameNavigation() {
        return usernameNavigation;
    }

    public void setUsernameNavigation(User usernameNavigation) {
        this.usernameNavigation = usernameNavigation;
    }
}