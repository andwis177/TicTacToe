package org.games.win_validator;

import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;

public class ResultFactory {
    WinCheck winCheck;

    public Win winProvider(Settings settings) {
        winCheck = new Row();
        Win winType = winCheck.win(settings);

        if (winType.win() != WinType.NOT_WIN) {
            return winType;
        } else {
            winCheck = new Column();
            winType = winCheck.win(settings);

            if (winType.win() != WinType.NOT_WIN) {
                return winType;
            } else {
                winCheck = new Diagonal();
                winType = winCheck.win(settings);

                if (winType.win() != WinType.NOT_WIN) {
                    return winType;
                } else {
                    winCheck = new DiagonalNegative();
                    winType = winCheck.win(settings);

                    if (winType.win() != WinType.NOT_WIN) {
                        return winType;
                    } else {
                        Draw draw = new Draw();
                        winType = draw.drawCheck(settings);
                        return winType;
                    }
                }
            }
        }
    }
}