package org.games.service.result;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.games.enums.results.ResultNodes;
import org.games.domains.Settings;
import org.games.enums.results.WinType;
import java.util.ArrayList;
import java.util.List;

public class SetImage {
    private final static String O_COLOR = "#ced7fc";
    private final static String X_COLOR = "#c7ffba";
    private final static String DRAW_COLOR = "#fffdcf";
    private final static int DRAW_IMAGE = 11;
    private final List<String> colorSet = new ArrayList<>();
    private final int imageNumber;

    public SetImage() {
        this.imageNumber = (int) (Math.random() * 10 + 1);
    }

    public void setImage(Settings settings, ResultNodes nodes) {
        setColors();
        if ((!settings.getWinType().equals(WinType.NOT_WIN.name())) &&
                (!settings.getWinType().equals(WinType.DRAW.name()))) {
            nodes.imageView().setImage(new Image("images/" + imageNumber + ".jpg"));
            nodes.rectangle().setFill(Color.valueOf(colorSet.get(settings.getPlayerTurn())));
        } else {
            if (settings.getWinType().equals(WinType.DRAW.name())) {
                nodes.imageView().setImage(new Image("images/" + DRAW_IMAGE + ".jpg"));
                nodes.rectangle().setFill(Color.valueOf(DRAW_COLOR));
            }
        }
    }
    private void setColors(){
        colorSet.add(O_COLOR);
        colorSet.add(X_COLOR);
    }
}
