package org.games.enums.settings;

public enum Colors {
    BLUE_O("#2c00bf"),
    GREEN_X("#00ae00"),
    BLUE_RECTANGLE("#96c4f5"),
    GREEN_RECTANGLE("#d0f8b4");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
