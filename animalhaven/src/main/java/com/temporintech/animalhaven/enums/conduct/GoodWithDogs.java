package com.temporintech.animalhaven.enums.conduct;

public enum GoodWithDogs {

    TRUE("Socialvel com cachorros"),
    FALSE("Não socialvel com cachorros");

    private String description;

    GoodWithDogs(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}