package com.reciclagus.question.model.quiz;

public class Alternative {

    private String txt;
    private boolean correct;

    public Alternative() {}

    public Alternative(String txt, boolean correct) {
        this.txt = txt;
        this.correct = correct;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
