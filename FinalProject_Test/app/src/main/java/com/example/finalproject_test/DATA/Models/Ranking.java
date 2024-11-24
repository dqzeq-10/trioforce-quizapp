package com.example.finalproject_test.DATA.Models;

public class Ranking {
    private String username;
    private int point;

    public Ranking(String username, int point) {
        this.username = username;
        this.point = point;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
