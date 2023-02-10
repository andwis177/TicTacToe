package org.games.win_validator;

import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;

public class Draw {
    public Win drawCheck(Settings settings) {
        long squareAvailable = settings.getBoard().getBoard().stream()
                .filter(square -> !square.isSet())
                .count();
        return squareAvailable <= 0 ? new Win(WinType.DRAW, 10) : new Win(WinType.NOT_WIN,0) ;
    }
}
