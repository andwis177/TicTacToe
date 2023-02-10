package org.games;

import org.games.computer.ComputerMoves;
import org.games.computer.Easy;
import org.games.computer.Hard;
import org.games.computer.Move;
import org.games.domains.Player;
import org.games.domains.Settings;
import org.games.domains.SquareSelect;
import org.games.enums.settings.BoardSizes;
import org.games.enums.settings.Symbol;
import org.games.service.game.BoardService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerMovesTestSuite {
    @Test
    void testCreateMoves() {
        //Given
        ComputerMoves computerMoves = new ComputerMoves();
        //When
        computerMoves.creatMoves(BoardSizes.SIZE_3.getBoardSize());
        int size = computerMoves.getEmptySquares().size();
        int square = computerMoves.getEmptySquares().get(4);
        //Then
        assertEquals(9, size);
        assertEquals(4, square);
    }
    @Test
    void testRemoveMove() {
        //Given
        ComputerMoves computerMoves = new ComputerMoves();
        computerMoves.creatMoves(BoardSizes.SIZE_3.getBoardSize());
        computerMoves.removePlayerMove(5);
        //When
        int size = computerMoves.getEmptySquares().size();
        //Then
        assertEquals(8, size);
    }
    @Test
    void testCreateEasyMove() {
        //Given
        Easy easy = new Easy();
        Settings settings = new Settings();
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().removePlayerMove(5);
        //When
        SquareSelect squareSelect = easy.move(settings);
        List<Integer> moveList = settings.getMovesCreator().getEmptySquares();
        //Then
        assertThat(squareSelect.getSquare()).isIn(moveList);
    }
    @Test
    void testCreateHardMoveFirst() {
        //Given
        Hard hard = new Hard();
        Settings settings = new Settings();
        Move move = new Move();
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        move.firstMoveListCreator();
        //When
        SquareSelect  squareSelect = hard.move(settings);
        //Then
        assertThat(squareSelect.getSquare()).isIn(move.getFirstMoves());
    }
    @Test
    void testCreateHardMoveSecond() {
        //Given
        Hard hard = new Hard();
        Settings settings = new Settings();
        settings.getBoard().createBoard(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().removePlayerMove(6);
        //When
        SquareSelect squareSelect = hard.move(settings);
        //Then
        assertEquals(4, squareSelect.getSquare());
    }
    @Test
    void testComputerBlockMove() {
        //Given
        Hard hard = new Hard();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.getBoard().createBoard(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.getPlayersList().add(new Player("Player 1", true, Symbol.O.getSymbol()));
        settings.getPlayersList().add(new Player("Player 2", true, Symbol.X.getSymbol()));
        settings.setPlayer(settings.getPlayersList().get(1));
        service.enterSymbol(2, settings);
        service.enterSymbol(4, settings);
        settings.switchPlayer();
        //When
        SquareSelect squareSelect = hard.move(settings);
        //Then
        assertEquals(6, squareSelect.getSquare());
    }
    @Test
    void testComputerWinMove() {
        //Given
        Hard hard = new Hard();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.getBoard().createBoard(BoardSizes.SIZE_3.getBoardSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 1", true, Symbol.O.getSymbol()));
        service.enterSymbol(2, settings);
        service.enterSymbol(4, settings);
        //When
        SquareSelect squareSelect = hard.move(settings);
        //Then
        assertEquals(6, squareSelect.getSquare());
    }
}
