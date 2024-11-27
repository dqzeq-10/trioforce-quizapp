package com.example.finalproject_test.DATA.Models;

public class Question {
    private int idQuestion;
    private String questionText;
    private int idSet;

    public Question(int idQuestion, String questionText, int idSet) {
        this.idQuestion = idQuestion;
        this.questionText = questionText;
        this.idSet = idSet;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getIdSet() {
        return idSet;
    }

    public void setIdSet(int idSet) {
        this.idSet = idSet;
    }
}
