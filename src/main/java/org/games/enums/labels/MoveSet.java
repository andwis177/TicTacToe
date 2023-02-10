package org.games.enums.labels;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public record MoveSet(Label label, Button button, Line line, int square) {
}
