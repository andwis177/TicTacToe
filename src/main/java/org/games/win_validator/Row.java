package org.games.win_validator;

import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;

public class Row implements WinCheck {
    @Override
    public Win win(Settings settings) {
        Win win = new Win(WinType.NOT_WIN,0);
        int row = 0;
        int column;
        int range = settings.getSize() - settings.getRequireToWin();
        while ((row < settings.getBoard().getBoard().size() - 1) && (win.win() == WinType.NOT_WIN)) {
            column = row;
            while ((column <= row + range) && (win.win() == WinType.NOT_WIN)) {
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
        int range = initSquare + settings.getRequireToWin();
        while ((lastSquare < range) &&
                (settings.getBoard().getBoard().get(lastSquare).getSymbol() == settings.getPlayer().getSymbol()) &&
                (count < settings.getRequireToWin())){
            lastSquare++;
            count++;
        }
        return  count >= settings.getRequireToWin() ? new Win(WinType.ROW, lastSquare-1) : new Win(WinType.NOT_WIN,0);
    }
}
