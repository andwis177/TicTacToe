package org.games;

import org.games.domains.Player;
import org.games.domains.Settings;
import org.games.enums.settings.BoardSizes;
import org.games.enums.settings.Symbol;
import org.games.service.game.BoardService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTestSuite {

    @Test
    void testSwitchPlayers() {
        //Given
        Settings settings = new Settings();
        settings.getPlayersList().add(new Player());
        settings.getPlayersList().add(new Player());
        settings.switchPlayer();
        //When
        int player = settings.getPlayerTurn();
        //Then
        assertEquals(1, player);
    }
    @Test
    void testEnterSymbol() {
        //Given
        BoardService boardService = new BoardService();
        Settings settings = new Settings();
        settings.getBoard().createBoard(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player1", true, Symbol.O.getSymbol()));
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        boardService.enterSymbol(2, settings);
        //When
        boolean squareAvailable = settings.getBoard().getBoard().get(2).isSet();
        int computerMovesBoardSize = settings.getMovesCreator().getEmptySquares().size();
        char symbol = settings.getBoard().getBoard().get(2).getSymbol();
        //Then
        assertTrue(squareAvailable);
        assertEquals('O',symbol);
        assertEquals(8, computerMovesBoardSize);
    }
}
