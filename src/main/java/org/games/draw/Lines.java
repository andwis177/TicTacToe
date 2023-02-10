package org.games.draw;

import javafx.scene.shape.Line;
import org.games.domains.Settings;
import org.games.domains.XYDirectory;

public interface Lines  {
    void draw(XYDirectory xYs, Line line, Settings settings);
}
