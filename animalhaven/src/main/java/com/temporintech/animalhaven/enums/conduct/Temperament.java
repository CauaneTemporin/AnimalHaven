package com.temporintech.animalhaven.enums.conduct;

public enum Temperament {

    CALM("Calmo"),
    PLAYFUL("Divertido"),
    SHY("Tímido"),
    AGGRESSIVE("Agressivo");

    private String description;

    Temperament(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}