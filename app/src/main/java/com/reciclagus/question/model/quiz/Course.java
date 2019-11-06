package com.reciclagus.question.model.quiz;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {

    private List<Module> modules;
    private String title;

    public Course() {}

    public Course(List<Module> modules, String title) {
        this.modules = modules;
        this.title = title;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
