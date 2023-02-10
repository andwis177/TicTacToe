package org.games.service.game;

import org.games.computer.LevelFactory;
import org.games.computer.Levels;
import org.games.controller.GameController;
import org.games.domains.Settings;
import org.games.enums.labels.GCLabel;
import org.games.enums.labels.MoveSet;
import org.games.computer.MoveSetFactory;
import org.games.enums.settings.Colors;
import org.games.enums.settings.RectangleSet;
import org.games.service.FileManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameService {
    private PlayerMove playerMove;
    private Settings settings;
    private final LabelSet labelSet;
    private final List<GCLabel> labelList;

    private Levels levels;

    public GameService() {
        this.settings = new Settings();
        this.labelSet = new LabelSet();
        this.labelList = new ArrayList<>();
    }

    public void resultInit(GameController controller) {
        FileManager fileManager = new FileManager();
        settings = fileManager.load();
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(settings.getSize());
        createLabelList(controller);
        labelSet.setLabels(labelList, settings , playerMove);
        settings.currentPlayer();
        playerMove  = new PlayerMove(settings, labelList);
        LevelFactory levelFactory = new LevelFactory();
        levels = levelFactory.selectLevel(settings);
        if (!settings.getPlayer().isHuman()) {
            computerMove(controller);
        }
    }

    private void createLabelList(GameController controller) {
        labelList.add(new GCLabel(controller.getPlayerO(), controller.getoWinCount(),
                new org.games.enums.labels.LabelSet(controller.getoLabel(), Colors.BLUE_O.getColor()), new RectangleSet(
                controller.getBlue(), Colors.BLUE_RECTANGLE.getColor())));
        labelList.add(new GCLabel(controller.getPlayerX(), controller.getxWinCount(),
                new org.games.enums.labels.LabelSet(controller.getxLabel(), Colors.GREEN_X.getColor()), new RectangleSet(
                controller.getGreen(), Colors.GREEN_RECTANGLE.getColor())));
    }

    public void humanMove(MoveSet set) {
        playerMove.move(set);
    }
    public void computerMove(GameController controller) {
        MoveSetFactory moveSetFactory = new MoveSetFactory();
        if (!settings.getPlayer().isHuman()) {
            MoveSet set = moveSetFactory.getMoveSet(controller, levels.move(settings).getSquare());
            if (set.square() != 1000) {
                playerMove.move(set);
            } else {
                Logger.getLogger(getClass().getName()).log(
                        Level.SEVERE, MoveSetFactory.class.getName() + " - Returned not allowed move!", this);
            }
        }
    }
}
