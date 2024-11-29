package com.example.finalproject_test.DATA.Models;

import java.util.List;

public class QuestionSet {
    private int idSet;
    private String setName;
    private String authorName;
    private Integer idLevel;
    private Integer idCategory;

    private User authorNameNavigation;
    private QuestionCategory idCategoryNavigation;
    private Level idLevelNavigation;
    private List<AnsweredQuestion> answeredQuestions;
    private List<ProgressQuestion> progressQuestions;
    private List<Question> questions;

    public QuestionSet(int idSet, String setName, String authorName, Integer idLevel, Integer idCategory, List<Question> questions) {
        this.idSet = idSet;
        this.setName = setName;
        this.authorName = authorName;
        this.idLevel = idLevel;
        this.idCategory = idCategory;
        this.questions = questions;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public User getAuthorNameNavigation() {
        return authorNameNavigation;
    }

    public void setAuthorNameNavigation(User authorNameNavigation) {
        this.authorNameNavigation = authorNameNavigation;
    }

    public QuestionCategory getIdCategoryNavigation() {
        return idCategoryNavigation;
    }

    public void setIdCategoryNavigation(QuestionCategory idCategoryNavigation) {
        this.idCategoryNavigation = idCategoryNavigation;
    }

    public Level getIdLevelNavigation() {
        return idLevelNavigation;
    }

    public void setIdLevelNavigation(Level idLevelNavigation) {
        this.idLevelNavigation = idLevelNavigation;
    }

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public List<ProgressQuestion> getProgressQuestions() {
        return progressQuestions;
    }

    public void setProgressQuestions(List<ProgressQuestion> progressQuestions) {
        this.progressQuestions = progressQuestions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
