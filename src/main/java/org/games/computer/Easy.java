package org.games.computer;

import org.games.domains.Settings;
import org.games.domains.SquareSelect;

import java.util.Random;

public class Easy implements Levels {
    @Override
    public SquareSelect move(Settings settings) {
        Random random = new Random();
        SquareSelect squareSelect = new SquareSelect();
        if (settings.getMovesCreator().getEmptySquares().size() > 0) {
            int square = random.nextInt(settings.getMovesCreator().getEmptySquares().size());
            squareSelect.set(settings.getMovesCreator().getEmptySquares().get(square));
        }
        return  squareSelect;
    }
}
