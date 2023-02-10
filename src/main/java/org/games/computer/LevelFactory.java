package org.games.computer;

import org.games.domains.Settings;
import org.games.enums.settings.GameLevel;

public class LevelFactory {
    public Levels selectLevel(Settings settings) {
        if (settings.getLevel().equalsIgnoreCase(GameLevel.EASY.getName())) {
            return new Easy();
        } else {
            if (settings.getLevel().equalsIgnoreCase(GameLevel.HARD.getName())) {
                return new Hard();
            } else {
                return new Easy();
            }
        }
    }
}
