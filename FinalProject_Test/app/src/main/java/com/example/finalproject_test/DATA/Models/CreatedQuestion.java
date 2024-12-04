package com.example.finalproject_test.DATA.Models;

import java.util.Date;
import java.util.List;

public class CreatedQuestion {
    private Date createdTime;
    private String categoryName;
    private String questionText;
    private List<Answer> answers;


    public CreatedQuestion() {
    }

    public CreatedQuestion(Date createdTime, String categoryName, String questionText, List<Answer> answers) {
        this.createdTime = createdTime;
        this.categoryName = categoryName;
        this.questionText = questionText;
        this.answers = answers;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
