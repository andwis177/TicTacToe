package org.games.enums.settings;

public enum BoardSizes {
    SIZE_3(3);
    private final int boardSize;

    BoardSizes(int boardSize) {
        this.boardSize = boardSize;
    }
    public int getBoardSize() {
        return boardSize;
    }
}
