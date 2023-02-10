package org.games.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {
    public List<Square> board = new ArrayList<>();

    public void createBoard(int size) {
        List<Square> newBoard = new ArrayList<>();
        for(int i=0; i < (size * size); i++){
            newBoard.add(new Square('-', false));
            this.board = newBoard;
        }
    }

    public List<Square> getBoard() {
        return board;
    }
}
