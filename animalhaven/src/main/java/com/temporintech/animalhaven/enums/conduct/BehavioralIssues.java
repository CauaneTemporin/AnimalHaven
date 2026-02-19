package com.temporintech.animalhaven.enums.conduct;

public enum BehavioralIssues {
    NONE("Sem problemas comportamentais"),
    ANXIETY("Ansiedade"),
    FEAR("Medo"),
    AGGRESSION("Agressivo");

    private String description;

    BehavioralIssues(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}