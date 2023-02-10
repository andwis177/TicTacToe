package org.games.enums.labels;

import javafx.scene.control.Label;
import org.games.enums.settings.RectangleSet;

public record GCLabel(Label name, Label winCount, LabelSet label, RectangleSet rectangle) {
}
