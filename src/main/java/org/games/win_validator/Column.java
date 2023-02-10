package org.games.win_validator;

import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;

public class Column implements WinCheck {
    @Override
    public Win win(Settings settings) {
        Win win = new Win(WinType.NOT_WIN, 0);
        int row = 0;
        int column;
        int range = settings.getSize() * settings.getRequireToWin();
        while ((row <= settings.getBoard().getBoard().size() - range) && (win.win() == WinType.NOT_WIN)) {
            column = row;
            while ((column < row + settings.getSize()) && (win.win() == WinType.NOT_WIN)){
                win = check(settings, column);
                column++;
            }
            row += settings.getSize();
        }
        return win;
    }

    @Override
    public Win check(Settings settings, int initSquare) {
        int lastSquare = initSquare;
        int count = 0;
        int range = (initSquare + (settings.getSize() * (settings.getRequireToWin() - 1)));
        while ((lastSquare <= range) &&
                (settings.getBoard().getBoard().get(lastSquare).getSymbol() == settings.getPlayer().getSymbol()) &&
                (count < settings.getRequireToWin())) {
            count++;
            lastSquare += settings.getSize();
        }
        return  count >= settings.getRequireToWin() ?
                new Win(WinType.COLUMN, initSquare) : new Win(WinType.NOT_WIN,0);
    }
}
