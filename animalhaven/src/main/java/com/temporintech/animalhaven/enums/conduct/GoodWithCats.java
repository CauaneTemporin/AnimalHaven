package com.temporintech.animalhaven.enums.conduct;

public enum GoodWithCats {

    TRUE("Socialvel com gatos"),
    FALSE("Não socialvel com gatos");

    private String description;

    GoodWithCats(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}