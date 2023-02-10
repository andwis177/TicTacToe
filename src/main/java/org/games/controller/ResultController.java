package org.games.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.games.domains.Settings;
import org.games.enums.results.ResultNodes;
import org.games.service.FileManager;
import org.games.service.result.SetImage;
import org.games.service.start.StartGame;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    @FXML
    private ImageView imageView;
    @FXML
    private Rectangle rectangle;
    private Settings settings;
    private Stage stage;
    private Stage mainStage;
    private final FileManager fileManager;

    public ResultController() {
        this.fileManager = new FileManager();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetImage setImage = new SetImage();
        settings =  fileManager.load();
        setImage.setImage(settings,new ResultNodes(imageView, rectangle));
    }

    public void getMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    private void nextGame(ActionEvent event) {
        StartGame start = new StartGame(stage, settings);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainStage.close();
        stage.close();
        start.start(event);
    }

    @FXML
    public void exit() {
        fileManager.save(settings);
        Platform.exit();
    }
}


