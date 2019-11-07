package com.reciclagus.question.model.util;

public class Result {

    boolean accept;
    String id;

    public Result(boolean accept, String id) {
        this.accept = accept;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Result{" +
                "accept=" + accept +
                ", id='" + id + '\'' +
                '}';
    }
}
