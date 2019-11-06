package com.reciclagus.question.model.quiz;

import java.util.List;

public class Module {

    private String title;
    private Content content;
    private int idQuestion;
    private List<Question> questions;

    public Module() {}

    public Module(String title, Content content, int idQuestion, List<Question> questions) {
        this.title = title;
        this.content = content;
        this.idQuestion = idQuestion;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
