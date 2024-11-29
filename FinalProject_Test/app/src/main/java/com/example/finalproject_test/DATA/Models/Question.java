package com.example.finalproject_test.DATA.Models;

import java.util.List;

public class Question {
    private int idQuestion;
    private String questionText;
    private Integer idSet;

    private QuestionSet idSetNavigation;
    private List<AnsweredQuestion> answeredQuestions;
    private List<Answer> answers;
    private List<CreatedQuestion> createdQuestions;
    private List<MarkedQuestion> markedQuestions;
    private List<ProgressQuestion> progressQuestions;

    public Question(int idQuestion, String questionText, int idSet) {
        this.idQuestion = idQuestion;
        this.questionText = questionText;
        this.idSet = idSet;
    }

    public Question(List<Answer> answers, Integer idSet, String questionText, int idQuestion) {
        this.answers = answers;
        this.idSet = idSet;
        this.questionText = questionText;
        this.idQuestion = idQuestion;
    }

    public Question(int idQuestion, List<Answer> answers) {
        this.idQuestion = idQuestion;
        this.answers = answers;
    }

    public void setIdSet(Integer idSet) {
        this.idSet = idSet;
    }

    public QuestionSet getIdSetNavigation() {
        return idSetNavigation;
    }

    public void setIdSetNavigation(QuestionSet idSetNavigation) {
        this.idSetNavigation = idSetNavigation;
    }

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<CreatedQuestion> getCreatedQuestions() {
        return createdQuestions;
    }

    public void setCreatedQuestions(List<CreatedQuestion> createdQuestions) {
        this.createdQuestions = createdQuestions;
    }

    public List<MarkedQuestion> getMarkedQuestions() {
        return markedQuestions;
    }

    public void setMarkedQuestions(List<MarkedQuestion> markedQuestions) {
        this.markedQuestions = markedQuestions;
    }

    public List<ProgressQuestion> getProgressQuestions() {
        return progressQuestions;
    }

    public void setProgressQuestions(List<ProgressQuestion> progressQuestions) {
        this.progressQuestions = progressQuestions;
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
