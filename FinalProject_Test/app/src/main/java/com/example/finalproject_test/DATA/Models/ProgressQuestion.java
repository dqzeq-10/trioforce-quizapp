package com.example.finalproject_test.DATA.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProgressQuestion implements Serializable {
    private Date savedTime;
    private String authorName;
    private int idSet;
    private String setName;
    private int questionCount;
    private int questionLastId;
    private List<Question> questions;
    private List<AnsweredQuestion> answered;


    public ProgressQuestion() {
    }

    public ProgressQuestion(int idSet, String authorName, Date savedTime, int questionCount, int questionLastId, List<Question> questions, List<AnsweredQuestion> answered) {
        this.idSet = idSet;
        this.authorName = authorName;
        this.savedTime = savedTime;
        this.questionCount = questionCount;
        this.questionLastId = questionLastId;
        this.questions = questions;
        this.answered = answered;
    }

    public Date getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(Date savedTime) {
        this.savedTime = savedTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getIdSet() {
        return idSet;
    }

    public void setIdSet(int idSet) {
        this.idSet = idSet;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<AnsweredQuestion> getAnswered() {
        return answered;
    }

    public void setAnswered(List<AnsweredQuestion> answered) {
        this.answered = answered;
    }
}
