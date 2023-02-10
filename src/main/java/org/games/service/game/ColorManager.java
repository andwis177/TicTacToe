package org.games.service.game;

import javafx.scene.paint.Color;
import org.games.domains.Settings;
import org.games.enums.labels.GCLabel;
import java.util.List;

public class ColorManager {
    private final Settings settings;
    private final List<GCLabel> labelList;

    public ColorManager(Settings settings, List<GCLabel> labelList) {
        this.settings = settings;
        this.labelList = labelList;
    }

    public void switchColors() {
        for (int i = 0; i < labelList.size(); i++) {
            if (i == settings.getPlayerTurn()) {
                labelList.get(i).label().label().setTextFill(Color.valueOf(
                        labelList.get(i).label().color()));
                labelList.get(i).rectangle().rectangle().setFill(Color.valueOf(
                        labelList.get(i).rectangle().color()));
            } else {
                labelList.get(i).label().label().setTextFill(Color.GRAY);
                labelList.get(i).rectangle().rectangle().setFill(Color.LIGHTGRAY);
            }
        }
    }
}
