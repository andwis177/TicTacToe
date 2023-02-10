package org.games.draw;

import javafx.scene.shape.Line;
import org.games.domains.Settings;
import org.games.domains.XYDirectory;
import org.games.enums.results.Win;

public class LineDrawer {
    private final XYDirectory startPoint = new XYDirectory();

    public void drawLine(Win win, Settings settings, Line line) {
        Lines lines = new Row();
        findStartPoint(win, settings);
        switch (win.win()) {
            case ROW -> {
                lines.draw(startPoint, line, settings);
            }
            case COLUMN -> {
                lines = new Column();
                lines.draw(startPoint, line, settings);
            }
            case DIAGONAL -> {
                lines = new Diagonal();
                lines.draw(startPoint, line, settings);
            }
            case DIAGONAL_NEGATIVE -> {
                lines = new DiagonalNegative();
                lines.draw(startPoint, line, settings);
            }
            default -> {}
        }
    }
    public void findStartPoint(Win win, Settings settings) {
        startPoint.setRow(win.start() / settings.getSize());
        if (win.start() < settings.getSize()) {
            startPoint.setColumn(win.start());
        } else {
            startPoint.setColumn(((win.start()) - (startPoint.getRow() * settings.getSize())));
        }
    }
}
