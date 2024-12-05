package com.example.finalproject_test.DATA.Models;

import java.io.Serializable;
import java.sql.Date;

public class MarkedQuestion implements Serializable {
    private String username;
    private int idQuestion;
    private Date markedTime;

    private Question idQuestionNavigation;
    private User usernameNavigation;

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
