package org.games.draw;

import javafx.scene.shape.Line;
import org.games.domains.Settings;
import org.games.domains.XYDirectory;

public class Column implements Lines {
    private static final int MOVE_AMOUNT_STR = 110;
    private static final int X_LAYOUT = 125;
    private static final int Y_LAYOUT = 125;

    @Override
    public void draw(XYDirectory xYs, Line line, Settings settings) {
        line.setLayoutX(X_LAYOUT);
        line.setLayoutY(Y_LAYOUT);
        line.setStartX(MOVE_AMOUNT_STR * xYs.getColumn());
        line.setStartY(MOVE_AMOUNT_STR * xYs.getRow());
        line.setEndX(line.getStartX());
        line.setEndY((line.getStartY() + (MOVE_AMOUNT_STR * settings.getRequireToWin())));
        line.setVisible(true);
    }
}
