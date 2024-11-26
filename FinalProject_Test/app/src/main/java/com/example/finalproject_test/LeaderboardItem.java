package com.example.finalproject_test;

public class LeaderboardItem {
    private final int rank;
    private final int avatarResId;
    private final String playerName;
    private final String score;

    public LeaderboardItem(int rank, int avatarResId, String playerName, String score) {
        this.rank = rank;
        this.avatarResId = avatarResId;
        this.playerName = playerName;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getScore() {
        return score;
    }
}
