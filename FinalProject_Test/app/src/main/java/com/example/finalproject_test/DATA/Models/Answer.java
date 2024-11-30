package com.example.finalproject_test.DATA.Models;

public class Answer {
    private int idAnswer;
    private int idQuestion;
    private String answerText;
    private boolean isCorrect;

    private Question idQuestionNavigation;


    public Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public Answer(int idAnswer, int idQuestion, String answerText, boolean isCorrect) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getAnswerText() {
        return answerText;
    }

    public Question getIdQuestionNavigation() {
        return idQuestionNavigation;
    }

    public void setIdQuestionNavigation(Question idQuestionNavigation) {
        this.idQuestionNavigation = idQuestionNavigation;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
