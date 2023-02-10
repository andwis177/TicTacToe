package org.games.domains;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private boolean isHuman;
    private char symbol;
    private int winCount;

    public Player(String name, boolean isHuman, char symbol) {
        this.name = name;
        this.isHuman = isHuman;
        this.symbol = symbol;
        this.winCount = 0;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWinCount() {
        return winCount;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void addWinCounter() {
        this.winCount++;
    }
}
