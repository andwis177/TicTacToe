package org.games.service.game;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.games.enums.labels.GCLabel;
import org.games.enums.labels.MoveSet;
import org.games.draw.LineDrawer;
import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;
import org.games.service.FileManager;
import org.games.stage.Result;
import org.games.win_validator.ResultFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerMove {
    private final BoardService service;
    private final ResultFactory winFactory;
    private final LineDrawer lineStart;
    private final Settings settings;
    private final List<GCLabel> labelList;
    private final ColorManager colorManager;

    public PlayerMove(Settings settings, List<GCLabel> labelList) {
        this.service = new BoardService();
        this.winFactory = new ResultFactory();
        this.lineStart = new LineDrawer();
        this.settings = settings;
        this.labelList = labelList;
        this.colorManager = new ColorManager(settings, labelList);
    }

    public void move(MoveSet set) {
        if (!getService().squareValidator(set.square(), settings)) {
            initMove(set);
            Win win = winExecution(set);
            if (win.win() != WinType.NOT_WIN) {
                endGameExecution(win, labelList.get(0).label().label());
            } else {
                nextMove();
            }
            settings.currentPlayer();
        } else {
            Logger.getLogger(getClass().getName()).log(
                    Level.SEVERE, "Trying to use already taken square", this);
        }
    }

    public void initMove(MoveSet set) {
        service.enterSymbol(set.square(), settings);
        set.label().setText(String.valueOf(settings.getPlayer().getSymbol()));
        set.label().setTextFill(Color.valueOf(labelList.get(settings.getPlayerTurn()).label().color()));
        set.button().setDisable(true);
    }

    public Win winExecution(MoveSet set) {
        Win win = winFactory.winProvider(settings);
        if ((win.win() != WinType.NOT_WIN) && (win.win() != WinType.DRAW)){
            settings.getPlayer().addWinCounter();
            lineStart.drawLine(winFactory.winProvider(settings), settings, set.line());
        }
        return win;
    }

    public void nextMove() {
        ColorManager colorManager = new ColorManager(settings, labelList);
        settings.switchPlayer();
        colorManager.switchColors();
    }

    public void endGameExecution(Win win, Label label) {
        FileManager fileManager = new FileManager();
        Result result = new Result();
        settings.setWinType(win.win().name());
        fileManager.save(settings);
        Stage thisStage = (Stage) label.getScene().getWindow();
        result.result(new Stage(), thisStage);
    }

    public BoardService getService() {
        return service;
    }

    public ColorManager getColorManager() {
        return colorManager;
    }
}
