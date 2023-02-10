package org.games.win_validator;

import org.games.domains.Settings;
import org.games.enums.results.Win;

public interface WinCheck {
   Win win(Settings settings);
   Win check(Settings settings, int initSquare);
}
