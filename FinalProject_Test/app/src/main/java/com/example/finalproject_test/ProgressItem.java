package com.example.finalproject_test;

public class ProgressItem {
    private final String monthYear;
    private final String title  ;
    private final String progress;
    private final String author;
    private final int avataResId;
    public ProgressItem(String monthYear,String title,String progress,String author,int avataResId){
        this.monthYear = monthYear;
        this.title = title;
        this.progress = progress;
        this.author=author;
        this.avataResId=avataResId;
    }


    public String getMonthYear() {
        return monthYear;
    }

    public String getTitle() {
        return title;
    }

    public String getProgress() {
        return progress;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvataResId() {
        return avataResId;
    }
}
