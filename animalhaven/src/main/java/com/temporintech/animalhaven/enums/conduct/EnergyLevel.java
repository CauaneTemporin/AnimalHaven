package com.temporintech.animalhaven.enums.conduct;

public enum EnergyLevel {
    LOW("Baixo"),
    MEDIUM("Médio"),
    HIGH("Alto");

    private String description;

    EnergyLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}