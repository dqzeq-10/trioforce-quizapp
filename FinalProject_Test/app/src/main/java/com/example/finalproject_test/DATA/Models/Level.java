package com.example.finalproject_test.DATA.Models;

public class Level {
    private int idLevels;
    private String levelName;

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

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
