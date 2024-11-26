package com.example.finalproject_test;

public class BookmarkedItem {
    private final String month;
    private final String category;
    private final String question;
    private final String answer;

    public BookmarkedItem(String month, String category, String question, String answer) {
        this.month = month;
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public String getMonth() {
        return month;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
