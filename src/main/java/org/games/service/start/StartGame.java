package org.games.service.start;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.games.service.FileManager;
import org.games.stage.StageInitiator;
import org.games.domains.StageSet;
import org.games.domains.Settings;

public class StartGame {
    private final static String FXML = "game-board.fxml";
    private final Stage stage;
    private final Settings settings;

    public StartGame(Stage stage, Settings settings) {
        this.stage = stage;
        this.settings = settings;
    }

    public void start(ActionEvent event) {
        StageInitiator initiator = new StageInitiator();
        FileManager save = new FileManager();
        save.save(settings);
        StageSet set = new StageSet(new Stage(),FXML);
        initiator.switchScene(event, set);
    }
}
