package org.games;

import javafx.application.Application;
import javafx.stage.Stage;
import org.games.domains.StageSet;
import org.games.stage.StageInitiator;

public class AppLauncher extends Application {
    private final static String FXML = "start-view.fxml";
    private final static String IMG = "cube.png";
    private final static String Title = "TicTacToeApp";

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) {
        StageInitiator initiator = new StageInitiator();
        StageSet set = new StageSet(stage,FXML);
        set.setImg(IMG);
        set.setTitle(Title);
        initiator.stageInitializer(set);
    }
}
