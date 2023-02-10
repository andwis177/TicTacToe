package org.games.domains;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class GameNode {
    private Label label;
    private Button button;
    private Line winLine;
    private int square;

    public GameNode(Label label, Button button, Line winLine, int square) {
        this.label = label;
        this.button = button;
        this.winLine = winLine;
        this.square = square;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
}
