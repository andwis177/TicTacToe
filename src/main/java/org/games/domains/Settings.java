package org.games.domains;

import org.games.computer.ComputerMoves;
import org.games.enums.settings.RequireToWin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Settings implements Serializable {
    private final Board board;
    private String level;
    private int size;
    private Player player;
    private final List<Player> playersList;
    private final ComputerMoves movesCreator;
    private int playerTurn;
    private final int requireToWin;
    private String winType;

    public Settings() {
        this.board = new Board();
        this.playersList = new ArrayList<>();
        this.movesCreator = new ComputerMoves();
        this.requireToWin = RequireToWin.THREE.getRequireToWin();
        this.playerTurn = 0;
    }

    public void switchPlayer() {
        if (playerTurn + 1 == playersList.size()) {
            this.playerTurn = 0;
        } else {
            if (playerTurn + 1 < playersList.size()) {
                this.playerTurn++;
            } else {
                Logger.getLogger("Player turn overstep player list size", Settings.class.getName());
            }
        }
        currentPlayer();
    }

    public void currentPlayer() {
        this.player = playersList.get(playerTurn);
    }

    public Board getBoard() {
        return board;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getRequireToWin() {
        return requireToWin;
    }

    public String getWinType() {
        return winType;
    }

    public void setWinType(String winType) {
        this.winType = winType;
    }

    public ComputerMoves getMovesCreator() {
        return movesCreator;
    }
}
