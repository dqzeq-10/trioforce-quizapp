package com.example.finalproject_test.DATA.Models;

import java.util.Date;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean sex;
    private Date birthday;

    private Ranking ranking;
    private List<AnsweredQuestion> answeredQuestions;
    private List<CreatedQuestion> createdQuestions;
    private List<MarkedQuestion> markedQuestions;
    private List<ProgressQuestion> progressQuestions;
    private List<QuestionSet> questionSets;

    public User(String username, String password, String name, String email, String phoneNumber, boolean sex, Date birthday) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthday = birthday;
    }
    public User(String username, List<QuestionSet> questionSets) {
        this.username = username;
        this.questionSets = questionSets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public List<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
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

    public List<QuestionSet> getQuestionSets() {
        return questionSets;
    }

    public void setQuestionSets(List<QuestionSet> questionSets) {
        this.questionSets = questionSets;
    }
}
