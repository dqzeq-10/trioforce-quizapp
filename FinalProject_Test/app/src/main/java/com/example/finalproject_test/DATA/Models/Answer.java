package com.example.finalproject_test.DATA.Models;

public class Answer {
    private int ID_Answer;
    private int ID_Question;
    private String AnswerText;
    private boolean isCorrect;

    public Answer(int ID_Answer, int ID_Question, String answerText, boolean isCorrect) {
        this.ID_Answer = ID_Answer;
        this.ID_Question = ID_Question;
        AnswerText = answerText;
        this.isCorrect = isCorrect;
    }

    public int getID_Answer() {
        return ID_Answer;
    }

    public void setID_Answer(int ID_Answer) {
        this.ID_Answer = ID_Answer;
    }

    public int getID_Question() {
        return ID_Question;
    }

    public void setID_Question(int ID_Question) {
        this.ID_Question = ID_Question;
    }

    public String getAnswerText() {
        return AnswerText;
    }

    public void setAnswerText(String answerText) {
        AnswerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
