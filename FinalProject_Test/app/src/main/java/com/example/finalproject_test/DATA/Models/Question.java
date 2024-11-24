package com.example.finalproject_test.DATA.Models;

public class Question {
    private int ID_Question;
    private String QuestionText;
    private int ID_Category;
    private int ID_Level;
    private int ID_Set;

    public Question(int ID_Question, String questionText, int ID_Category, int ID_Level, int ID_Set) {
        this.ID_Question = ID_Question;
        QuestionText = questionText;
        this.ID_Category = ID_Category;
        this.ID_Level = ID_Level;
        this.ID_Set = ID_Set;
    }

    public int getID_Question() {
        return ID_Question;
    }

    public void setID_Question(int ID_Question) {
        this.ID_Question = ID_Question;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }

    public int getID_Category() {
        return ID_Category;
    }

    public void setID_Category(int ID_Category) {
        this.ID_Category = ID_Category;
    }

    public int getID_Level() {
        return ID_Level;
    }

    public void setID_Level(int ID_Level) {
        this.ID_Level = ID_Level;
    }

    public int getID_Set() {
        return ID_Set;
    }

    public void setID_Set(int ID_Set) {
        this.ID_Set = ID_Set;
    }
}
