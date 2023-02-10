package org.games.computer;

import org.games.domains.Settings;
import org.games.domains.Square;
import org.games.domains.SquareSelect;
import org.games.enums.settings.Symbol;
import java.util.List;

public class BlockMove {
    public SquareSelect blockMove(Settings settings) {
        List<Square> board = settings.getBoard().getBoard();
        SquareSelect squareSelect = new SquareSelect();
        int i = 0;
        while ((i < settings.getBoard().getBoard().size()) && (!squareSelect.isSet())) {
            if (board.get(i).getSymbol() == Symbol.O.getSymbol()) {
                switch (i) {
                    case 0 -> {
                        if ((board.get(1).getSymbol() == Symbol.O.getSymbol()) && !(board.get(2).isSet())) {
                            squareSelect.set(2);
                        }
                        if ((board.get(2).getSymbol() == Symbol.O.getSymbol()) && !(board.get(1).isSet())) {
                            squareSelect.set(1);
                        }
                        if ((board.get(3).getSymbol() == Symbol.O.getSymbol()) && !(board.get(6).isSet())) {
                            squareSelect.set(6);
                        }
                        if ((board.get(4).getSymbol() == Symbol.O.getSymbol()) && !(board.get(8).isSet())) {
                            squareSelect.set(8);
                        }
                        if ((board.get(6).getSymbol() == Symbol.O.getSymbol()) && !(board.get(3).isSet())) {
                            squareSelect.set(3);
                        }
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(4).isSet())) {
                            squareSelect.set(4);
                        }
                    }
                    case 1 -> {
                        if ((board.get(4).getSymbol() == Symbol.O.getSymbol()) && !(board.get(7).isSet())) {
                            squareSelect.set(7);
                        }
                        if ((board.get(2).getSymbol() == Symbol.O.getSymbol()) && !(board.get(0).isSet())) {
                            squareSelect.set(0);
                        }
                        if ((board.get(7).getSymbol() == Symbol.O.getSymbol()) && !(board.get(4).isSet())) {
                            squareSelect.set(4);
                        }
                    }
                    case 2 -> {
                        if ((board.get(4).getSymbol() == Symbol.O.getSymbol()) && !(board.get(6).isSet())) {
                            squareSelect.set(6);
                        }
                        if ((board.get(5).getSymbol() == Symbol.O.getSymbol()) && !(board.get(8).isSet())) {
                            squareSelect.set(8);
                        }
                        if ((board.get(6).getSymbol() == Symbol.O.getSymbol()) && !(board.get(4).isSet())) {
                            squareSelect.set(4);
                        }
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(5).isSet())) {
                            squareSelect.set(5);
                        }
                    }
                    case 3 -> {
                        if ((board.get(4).getSymbol() == Symbol.O.getSymbol()) && !(board.get(5).isSet())) {
                            squareSelect.set(5);
                        }
                        if ((board.get(5).getSymbol() == Symbol.O.getSymbol()) && !(board.get(4).isSet())) {
                            squareSelect.set(4);
                        }
                        if ((board.get(6).getSymbol() == Symbol.O.getSymbol()) && !(board.get(0).isSet())) {
                            squareSelect.set(0);
                        }
                    }
                    case 4 -> {
                        if ((board.get(5).getSymbol() == Symbol.O.getSymbol()) && !(board.get(3).isSet())) {
                            squareSelect.set(3);
                        }
                        if ((board.get(7).getSymbol() == Symbol.O.getSymbol()) && !(board.get(1).isSet())) {
                            squareSelect.set(1);
                        }
                        if ((board.get(6).getSymbol() == Symbol.O.getSymbol()) && !(board.get(2).isSet())) {
                            squareSelect.set(2);
                        }
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(0).isSet())) {
                            squareSelect.set(0);
                        }
                    }
                    case 5 -> {
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(2).isSet())) {
                            squareSelect.set(2);
                        }
                    }
                    case 6 -> {
                        if ((board.get(7).getSymbol() == Symbol.O.getSymbol()) && !(board.get(8).isSet())) {
                            squareSelect.set(8);
                        }
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(7).isSet())) {
                            squareSelect.set(7);
                        }
                    }
                    case 7 -> {
                        if ((board.get(8).getSymbol() == Symbol.O.getSymbol()) && !(board.get(6).isSet())) {
                            squareSelect.set(6);
                        }
                    }
                }
            }
        i++;
        }
        return squareSelect;
    }
}
