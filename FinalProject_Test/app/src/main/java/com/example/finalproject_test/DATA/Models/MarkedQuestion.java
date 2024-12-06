package com.example.finalproject_test.DATA.Models;

import java.util.Date;
import java.util.List;

public class MarkedQuestion {
    private String username;
    private int idQuestion;
    private Date markedTime;
    private String categoryName;
    private String questionText;
    private List<Answer> answers;

    public MarkedQuestion() {
    }

    public MarkedQuestion(String username, int idQuestion) {
        this.username = username;
        this.idQuestion = idQuestion;
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
