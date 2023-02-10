package org.games.computer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComputerMoves implements Serializable {
    private List<Integer> emptySquares;

    public ComputerMoves() {
        this.emptySquares = new ArrayList<>();
    }

    public void creatMoves(int boardSize) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < boardSize * boardSize;) {
            newList.add(i);
            i++;
        }
        this.emptySquares = newList;
    }

    public List<Integer> getEmptySquares() {
        return emptySquares;
    }

    public void removePlayerMove(int square) {
        RemoveFromList remove = new RemoveFromList();
        remove.removeFromList(emptySquares, square);
    }
}
