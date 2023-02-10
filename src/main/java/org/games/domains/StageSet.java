package org.games.domains;

import javafx.stage.Stage;

public class StageSet {
    private Stage stage;
    private String fxml;
    private String img;
    private String title;

    public StageSet(Stage stage, String fxml) {
        this.stage = stage;
        this.fxml = fxml;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getFxml() {
        return fxml;
    }

    public void setFxml(String fxml) {
        this.fxml = fxml;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "StageSet: " +
                "\nStage = " + stage +
                "\nFxml = " + fxml +
                "\nImg = " + img +
                "\nTitle = " + title;
    }
}
