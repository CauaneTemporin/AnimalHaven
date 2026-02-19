package com.temporintech.animalhaven.enums.conduct;

public enum Sociability {
    FRIENDLY("Amigável"),
    SELECTIVE("Seletivo"),
    UNSOCIAL("Não social");

    private String description;

    Sociability(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}