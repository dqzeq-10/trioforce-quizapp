package com.example.finalproject_test.DATA.Models;

import java.io.Serializable;
import java.sql.Date;

public class ProgressQuestion implements Serializable {
    private String username;
    private int idSet;
    private int questionCount;
    private int questionLastId;
    private Date saveTime;

    private QuestionSet idSetNavigation;
    private Question questionLast;
    private User usernameNavigation;

    public ProgressQuestion(String username, int idSet, int questionCount, int questionLastId, Date saveTime) {
        this.username = username;
        this.idSet = idSet;
        this.questionCount = questionCount;
        this.questionLastId = questionLastId;
        this.saveTime = saveTime;
    }

    public QuestionSet getIdSetNavigation() {
        return idSetNavigation;
    }

    public void setIdSetNavigation(QuestionSet idSetNavigation) {
        this.idSetNavigation = idSetNavigation;
    }

    public Question getQuestionLast() {
        return questionLast;
    }

    public void setQuestionLast(Question questionLast) {
        this.questionLast = questionLast;
    }

    public User getUsernameNavigation() {
        return usernameNavigation;
    }

    public void setUsernameNavigation(User usernameNavigation) {
        this.usernameNavigation = usernameNavigation;
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

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getQuestionLastId() {
        return questionLastId;
    }

    public void setQuestionLastId(int questionLastId) {
        this.questionLastId = questionLastId;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }
}
