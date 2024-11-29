package com.example.finalproject_test.DATA.Models;

import java.sql.Date;

public class CreatedQuestion {
    private String username;
    private int idQuestion;
    private Date createdTime;

    private Question idQuestionNavigation;
    private User usernameNavigation;

    public Question getIdQuestionNavigation() {
        return idQuestionNavigation;
    }

    public void setIdQuestionNavigation(Question idQuestionNavigation) {
        this.idQuestionNavigation = idQuestionNavigation;
    }

    public User getUsernameNavigation() {
        return usernameNavigation;
    }

    public void setUsernameNavigation(User usernameNavigation) {
        this.usernameNavigation = usernameNavigation;
    }

    public CreatedQuestion(String username, int idQuestion, Date createdTime) {
        this.username = username;
        this.idQuestion = idQuestion;
        this.createdTime = createdTime;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
