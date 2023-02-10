package org.games.service.game;

import org.games.domains.Settings;
import org.games.enums.labels.GCLabel;
import java.util.List;

public class LabelSet {
    public void setLabels(List<GCLabel> labelList, Settings settings, PlayerMove playerMove) {
        if (labelList.size() >= settings.getPlayersList().size()) {
            for (int i = 0; i < labelList.size(); i++) {
                labelList.get(i).name().setText(settings.getPlayersList().get(i).getName());
                labelList.get(i).winCount().setText(String.valueOf(settings.getPlayersList().get(i).getWinCount()));
            }
            playerMove = new PlayerMove(settings, labelList);
            playerMove.getColorManager().switchColors();
        }
    }
}
