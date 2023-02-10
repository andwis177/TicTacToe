package org.games.enums.settings;

public enum RequireToWin {
    THREE(3);
    private final int requireToWin;

    RequireToWin(int requireToWin) {
        this.requireToWin = requireToWin;
    }

    public int getRequireToWin() {
        return requireToWin;
    }
}
