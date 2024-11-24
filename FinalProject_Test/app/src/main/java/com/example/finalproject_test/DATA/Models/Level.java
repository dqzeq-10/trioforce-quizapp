package com.example.finalproject_test.DATA.Models;

public class Level {
    private int ID_Levels;
    private String LevelName;

    public Level(int ID_Levels, String levelName) {
        this.ID_Levels = ID_Levels;
        LevelName = levelName;
    }

    public int getID_Levels() {
        return ID_Levels;
    }

    public void setID_Levels(int ID_Levels) {
        this.ID_Levels = ID_Levels;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String levelName) {
        LevelName = levelName;
    }
}
