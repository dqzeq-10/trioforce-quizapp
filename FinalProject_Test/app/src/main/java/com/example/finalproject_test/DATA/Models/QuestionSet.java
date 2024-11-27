package com.example.finalproject_test.DATA.Models;

public class QuestionSet {
    private int idSet;
    private String setName;
    private String authorName;
    private int idLevel;
    private int idCategory;

    public QuestionSet(int idSet, String setName, String authorName, int idLevel, int idCategory) {
        this.idSet = idSet;
        this.setName = setName;
        this.authorName = authorName;
        this.idLevel = idLevel;
        this.idCategory = idCategory;
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

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
