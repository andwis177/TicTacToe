package org.games.computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Move {
    private final WinMove forWin;
    private final BlockMove forBlock;
    private final Random rand;
    private final List<Integer> firstMoves;

    public Move() {
        this.forWin = new WinMove();
        this.forBlock = new BlockMove();
        this.rand = new Random();
        this.firstMoves = new ArrayList<>();
    }

    public void firstMoveListCreator(){
        firstMoves.add(0);
        firstMoves.add(2);
        firstMoves.add(6);
        firstMoves.add(8);
    }

    public WinMove getForWin() {
        return forWin;
    }

    public BlockMove getForBlock() {
        return forBlock;
    }

    public Random getRand() {
        return rand;
    }

    public List<Integer> getFirstMoves() {
        return firstMoves;
    }
}
