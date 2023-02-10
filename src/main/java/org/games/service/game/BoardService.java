package org.games.service.game;

import org.games.domains.Settings;

public class BoardService {
    public boolean squareValidator(int square, Settings settings) {
        return settings.getBoard().getBoard().get(square).isSet() ;
    }
    public void enterSymbol(int square, Settings settings) {
      settings.getBoard().getBoard().get(square).setSymbol(settings.getPlayer().getSymbol());
      settings.getBoard().getBoard().get(square).setSet(true);
      settings.getMovesCreator().removePlayerMove(square);
    }
}
