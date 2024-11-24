package com.example.finalproject_test.DATA.Models;

public class QuestionSet {
    private int ID_Set;
    private String SetName;
    private String AuthorName;

    public QuestionSet(int ID_Set, String setName, String authorName) {
        this.ID_Set = ID_Set;
        SetName = setName;
        AuthorName = authorName;
    }

    public int getID_Set() {
        return ID_Set;
    }

    public void setID_Set(int ID_Set) {
        this.ID_Set = ID_Set;
    }

    public String getSetName() {
        return SetName;
    }

    public void setSetName(String setName) {
        SetName = setName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
