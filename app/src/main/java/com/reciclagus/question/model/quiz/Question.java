package com.reciclagus.question.model.quiz;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    private String statiment;
    private List<Alternative> alternatives;

    public Question() {
    }

    public Question(String statiment, List<Alternative> alternatives) {
        this.statiment = statiment;
        this.alternatives = alternatives;
    }

    public String getStatiment() {
        return statiment;
    }

    public void setStatiment(String statiment) {
        this.statiment = statiment;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }
}
