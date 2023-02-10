package org.games.service.start;

import org.games.controller.StartController;
import org.games.enums.labels.SCLabel;
import org.games.domains.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetPlayer {
    private static final String HUMAN = "Human";
    private static final String COMPUTER = "Computer";

    public void setPlayer(StartController controller) {
        try {
            addPlayer(controller);
            if (controller.getLabelNumber() == controller.getLabelList().size()-1) {
                setButtons(controller);
            } else {
                setNameLabel(controller);
            }
        } catch (Exception ex) {
            Logger.getLogger(SetPlayer.class.getName()).log(Level.SEVERE, "Couldn't set player", ex);
        }
    }

    public void addPlayer(StartController controller) {
        SCLabel labelsSet = controller.getLabelList().get(controller.getLabelNumber());
        labelsSet.name().setText(controller.getName().getText());
        labelsSet.humanOrNot().setText(isHuman(controller));
        controller.getSettings().getPlayersList().add(new Player(
                controller.getName().getText(), controller.getIsHuman().isSelected(),labelsSet.symbol().getSymbol()));
        labelsSet.name().setVisible(true);
        controller.getIsHuman().setDisable(false);
    }

    public void setButtons(StartController controller) {
        controller.getOkButton().setDisable(true);
        controller.getNextButton().setDisable(false);
    }

    public void setNameLabel(StartController controller) {
        controller.nextLabelNumber();
        controller.getTextLabel().setText(
                "Name for: " + controller.getLabelList().get(controller.getLabelNumber()).symbol().getSymbol());
        controller.getName().setText(controller.getLabelList().get(controller.getLabelNumber()).name().getText());
    }

    private String isHuman(StartController ctr) {
        if (ctr.getIsHuman().isSelected()) {
            return HUMAN;
        } else {
            return COMPUTER;
        }
    }
}
