package com.temporintech.animalhaven.enums.conduct;

public enum HouseTrained {

    TRUE("Treinado para viver dentro de casa"),
    FALSE("Não é treinado para viver dentro de casa");

    private String description;

    HouseTrained(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}