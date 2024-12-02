package com.example.finalproject_test.DATA.Models;

import java.util.List;

public class QuestionCategory {
    private int idCategory;
    private String categoryName;
        private int imageResId;
    private List<QuestionSet> questionSets;


        public QuestionCategory(int imageResId) {
        this.imageResId = imageResId;
    }


    public QuestionCategory(int idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    public QuestionCategory(int idCategory, String categoryName, List<QuestionSet> questionSets) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.questionSets = questionSets;
    }

    public List<QuestionSet> getQuestionSets() {
        return questionSets;
    }

    public void setQuestionSets(List<QuestionSet> questionSets) {
        this.questionSets = questionSets;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
