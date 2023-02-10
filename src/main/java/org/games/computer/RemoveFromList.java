package org.games.computer;


import java.util.List;
public class RemoveFromList {
    public void removeFromList(List<Integer> emptySquares, int square) {
        List<Integer> copy = emptySquares.stream().filter(s -> s != square).toList();
        emptySquares.clear();
        emptySquares.addAll(copy);
    }
}
