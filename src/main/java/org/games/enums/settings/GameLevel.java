package org.games.enums.settings;

import java.util.ArrayList;
import java.util.List;

public enum GameLevel {
    EASY("Easy"),
    HARD("Hard");
    private final String name;

    GameLevel(String name) {
        this.name = name;
    }

    public List<String> getLevels() {
        List<String> levelList = new ArrayList<>();
        levelList.add(EASY.getName());
        levelList.add(HARD.getName());
        return levelList;
    }

    public String getName() {
        return name;
    }
}
