package org.games.stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.games.controller.ResultController;
import org.games.domains.StageSet;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StageInitiator {
    public void stageInitializer(StageSet set) {
        try {
            setStage(set);
            set.getStage().show();
        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(
                    Level.SEVERE,
                    "Couldn't create Stage\n" + getClass().getName() + "\n" + e + "\n" + set.toString(), this);
        }
    }

    public void stageInitWithParent(StageSet set, Stage mainStage) {
        try {
            FXMLLoader fxmlLoader = setStage(set);
            ResultController controller = fxmlLoader.getController();
            controller.getMainStage(mainStage);
            set.getStage().show();

        } catch(Exception e) {
            Logger.getLogger(getClass().getName()).log(
                    Level.SEVERE,
                    "Couldn't create Stage\n" + getClass().getName() + "\n" + e + "\n" + set.toString(), this);
        }
    }

    public void switchScene(ActionEvent event,StageSet set) {
        try {
            set.setStage((Stage) ((Node) event.getSource()).getScene().getWindow());
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/" + set.getFxml()))));
            set.getStage().setScene(scene);
            set.getStage().show();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(
                    Level.SEVERE,
                    "Couldn't create Stage\n" + getClass().getName() + "\n" + e + "\n" + set.toString(), this);
        }
    }

    private FXMLLoader setStage(StageSet set) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/" + set.getFxml()));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("images/" + set.getImg());
        set.getStage().getIcons().add(icon);
        set.getStage().setTitle(set.getTitle());
        set.getStage().setResizable(false);
        set.getStage().setScene(scene);
        set.getStage().centerOnScreen();
        return fxmlLoader;
    }
}
