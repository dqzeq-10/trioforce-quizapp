package com.example.finalproject_test.DATA.Models;

import java.util.List;

public class Level {
    private int idLevels;
    private String levelName;


    private List<QuestionSet> questionSets;

    public Level(int idLevels, String levelName) {
        this.idLevels = idLevels;
        this.levelName = levelName;
    }

    public int getIdLevels() {
        return idLevels;
    }

    public void setIdLevels(int idLevels) {
        this.idLevels = idLevels;
    }

    public String getLevelName() {
        return levelName;

    }
    public List<QuestionSet> getQuestionSets() {
        return questionSets;
    }

    public void setQuestionSets(List<QuestionSet> questionSets) {
        this.questionSets = questionSets;

    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
