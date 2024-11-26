package com.example.finalproject_test;

public class CreatedItem {
    private final String month;
    private final String category;
    private final String title;

    public CreatedItem(String month, String category, String title) {
        this.month = month;
        this.category = category;
        this.title = title;

    }

    public String getMonth() {
        return month;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }


}
