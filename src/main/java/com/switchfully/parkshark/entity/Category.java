package com.switchfully.parkshark.entity;

public enum Category {
    UNDERGROUND("undergournd building"),
    ABOVE_GROUND("above ground building");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
