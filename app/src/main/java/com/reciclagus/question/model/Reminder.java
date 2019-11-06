package com.reciclagus.question.model;

import java.util.Calendar;

public class Reminder {

    private int id;
    private String title;
    private String content;
    private boolean on;
    private String date;

    public Reminder(int id, String title, String content, boolean on, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.on = on;
        this.date = date;
    }

    public Reminder() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setOn(String on) {
        this.on = Boolean.getBoolean(on);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
