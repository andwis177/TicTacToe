package org.games.stage;

import javafx.stage.Stage;
import org.games.domains.StageSet;

public class Result {
    private final static String FXML = "game-result.fxml";
    private final static String IMG = "cube.png";
    private final static String Title = "TicTacToeApp";

    public void result(Stage stage, Stage mainStage) {
        StageInitiator initiator = new StageInitiator();
        StageSet set = new StageSet(stage,FXML);
        set.setImg(IMG);
        set.setTitle(Title);
        initiator.stageInitWithParent(set, mainStage);
    }
}
