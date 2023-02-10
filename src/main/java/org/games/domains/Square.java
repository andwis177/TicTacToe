package org.games.domains;

import java.io.Serializable;

public class Square implements Serializable {
    private char symbol;
    private boolean set;

    public Square(char symbol, boolean set) {
        this.symbol = symbol;
        this.set = set;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }
}
