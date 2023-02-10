package org.games.domains;

public class SquareSelect {
    private int square;
    private boolean set;

    public SquareSelect() {
        this.square = 0;
        this.set = false;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public void set(int square) {
        this.square = square;
        this.set = true;
    }
}
