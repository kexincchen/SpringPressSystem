package com.example.pressresource.entity;

public enum Placement {
    SPLASH,
    POPUP,
    HOMEPAGE,
    COMMENT,
    ARTICLE,
    ARTICLE_END,
    NEWS;

    public static Placement fromString(String value) {
        for (Placement placement : values()) {
            if (placement.name().equalsIgnoreCase(value)) {
                return placement;
            }
        }
        System.out.println(value);
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }


}
