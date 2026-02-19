package com.temporintech.animalhaven.enums.conduct;

public enum TrainingLevel {

    NONE("Sem treinamento"),
    BASIC("Treinamento básico"),
    ADVANCED("Treinamento avançado");

    private String description;

    TrainingLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}