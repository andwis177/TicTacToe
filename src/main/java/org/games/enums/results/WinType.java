package org.games.enums.results;

public enum WinType {
    NOT_WIN(),
    ROW(),
    COLUMN(),
    DIAGONAL(),
    DIAGONAL_NEGATIVE(),
    DRAW();

    WinType() {
    }
}
