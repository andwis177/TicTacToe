package org.games.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.games.enums.labels.SCLabel;
import org.games.domains.Settings;
import org.games.enums.settings.BoardSizes;
import org.games.enums.settings.GameLevel;
import org.games.enums.settings.Symbol;
import org.games.service.FileManager;
import org.games.service.start.SetPlayer;
import org.games.service.start.StartGame;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private CheckBox isHuman;
    @FXML
    private Label oName;
    @FXML
    private Label xName;
    @FXML
    private Label textLabel;
    @FXML
    private Label oHumanOrNot;
    @FXML
    private Label xHumanOrNot;
    @FXML
    private Button okButton;
    @FXML
    private Button nextButton;
    @FXML
    private ComboBox<String> levelBox;
    private Settings settings;
    private final FileManager fileManager;
    private final List<SCLabel> labelList;
    private final GameLevel levels ;
    private int labelNumber;

    public StartController() {
        this.settings = new Settings();
        this.fileManager = new FileManager();
        this.labelList = new ArrayList<>();
        this.levels =  GameLevel.EASY ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        levelBox.getItems().addAll(levels.getLevels());
        settings.setLevel(levelBox.getPromptText());
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        createLabelList();
    }
    protected void createLabelList(){
        labelList.add(new SCLabel(oName, oHumanOrNot, Symbol.O));
        labelList.get(0).name().setText("Player 1");
        labelList.add(new SCLabel(xName,xHumanOrNot, Symbol.X));
        labelList.get(1).name().setText("Player 2");
        labelNumber = 0;
    }

    public void nextLabelNumber() {
        labelNumber++;
    }

    @FXML
    private void setPlayer() {
        SetPlayer setPlayers = new SetPlayer();
        setPlayers.setPlayer(this);
    }
    @FXML
    private void changeLevelBoxValue() {
        levelBox.setPromptText(levelBox.getValue());
        settings.setLevel(levelBox.getValue());
    }
    @FXML
    private void startGame(ActionEvent event) {
        StartGame start = new StartGame(new Stage(), settings);
        start.start(event);
    }
    @FXML
    private void loadGame(ActionEvent event) {
        settings = fileManager.load();
        StartGame start = new StartGame(new Stage(), settings);
        start.start(event);
    }
    @FXML
    private void exitButton() {
        Platform.exit();
    }

    public List<SCLabel> getLabelList() {
        return labelList;
    }

    public int getLabelNumber() {
        return labelNumber;
    }

    public TextField getName() {
        return name;
    }

    public CheckBox getIsHuman() {
        return isHuman;
    }

    public Label getTextLabel() {
        return textLabel;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Settings getSettings() {
        return settings;
    }
}
