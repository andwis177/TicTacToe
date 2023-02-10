package org.games.computer;

import org.games.domains.Settings;
import org.games.domains.SquareSelect;

public class Hard implements Levels {
    private final Move move;
    public Hard() {
        this.move = new Move();
    }
    @Override
    public SquareSelect move(Settings settings) {
        move.firstMoveListCreator();
        SquareSelect squareSelect = new SquareSelect();
        if (settings.getMovesCreator().getEmptySquares().size() > 0) {
            switch (settings.getMovesCreator().getEmptySquares().size()) {
                case 9 -> {
                    squareSelect.set(move.getFirstMoves().get(move.getRand().nextInt(move.getFirstMoves().size())));
                    return squareSelect;
                }
                case 8 -> {
                    if (!settings.getBoard().getBoard().get(4).isSet()) {
                        squareSelect.set(4);
                        return squareSelect;
                    }
                }
                case 7,6,5,4,3,2,1 -> {
                    squareSelect = move.getForWin().winMove(settings);
                    if (squareSelect.isSet()) {
                        return squareSelect;
                    } else {
                        squareSelect = move.getForBlock().blockMove(settings);
                        if (squareSelect.isSet()) {
                            return squareSelect;
                        }
                    }
                }
            }
        }
        if (!squareSelect.isSet()) {
            int square = move.getRand().nextInt(settings.getMovesCreator().getEmptySquares().size());
            squareSelect.set(settings.getMovesCreator().getEmptySquares().get(square));
        }
        return  squareSelect;
    }
}
