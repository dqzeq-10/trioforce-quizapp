package com.example.finalproject_test.DATA.Models;

public class QuestionCategory {
    private int ID_Category;
    private String CategoryName;

    public QuestionCategory(int ID_Category, String categoryName) {
        this.ID_Category = ID_Category;
        CategoryName = categoryName;
    }

    public int getID_Category() {
        return ID_Category;
    }

    public void setID_Category(int ID_Category) {
        this.ID_Category = ID_Category;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
