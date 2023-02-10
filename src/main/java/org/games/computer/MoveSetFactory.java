package org.games.computer;

import org.games.controller.GameController;
import org.games.enums.labels.MoveSet;

public class MoveSetFactory {
    public MoveSet getMoveSet(GameController controller, int square) {
        switch (square) {
            case 0 -> { return new MoveSet(controller.getLabel1(), controller.getButton1(), controller.getWinLine(), square);}
            case 1 -> { return new MoveSet(controller.getLabel2(), controller.getButton2(), controller.getWinLine(), square);}
            case 2 -> { return new MoveSet(controller.getLabel3(), controller.getButton3(), controller.getWinLine(), square);}
            case 3 -> { return new MoveSet(controller.getLabel4(), controller.getButton4(), controller.getWinLine(), square);}
            case 4 -> { return new MoveSet(controller.getLabel5(), controller.getButton5(), controller.getWinLine(), square);}
            case 5 -> { return new MoveSet(controller.getLabel6(), controller.getButton6(), controller.getWinLine(), square);}
            case 6 -> { return new MoveSet(controller.getLabel7(), controller.getButton7(), controller.getWinLine(), square);}
            case 7 -> { return new MoveSet(controller.getLabel8(), controller.getButton8(), controller.getWinLine(), square);}
            case 8 -> { return new MoveSet(controller.getLabel9(), controller.getButton9(), controller.getWinLine(), square);}
            default -> {return new MoveSet(controller.getLabel1(), controller.getButton1(), controller.getWinLine(), 1000);}
        }
    }
}
