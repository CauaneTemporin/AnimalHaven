package com.temporintech.animalhaven.enums.conduct;

public enum GoodWithChildren {

    TRUE("Socialvel com crianças"),
    FALSE("Não socialvel com crianças");

    private String description;

    GoodWithChildren(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}