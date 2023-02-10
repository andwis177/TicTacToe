package org.games.enums.settings;

public enum Symbol {
    X('X'),
    O('O');
    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
