package com.example.finalproject_test.DATA.Models;

import java.util.Date;
import java.util.List;

public class MarkedQuestion {
    private Date markedTime;
    private String categoryName;
    private String questionText;
    private List<Answer> answers;

    public MarkedQuestion() {
    }

    public MarkedQuestion(Date markedTime, String categoryName, String questionText, List<Answer> answers) {
        this.markedTime = markedTime;
        this.categoryName = categoryName;
        this.questionText = questionText;
        this.answers = answers;
    }

    public Date getMarkedTime() {
        return markedTime;
    }

    public void setMarkedTime(Date markedTime) {
        this.markedTime = markedTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}