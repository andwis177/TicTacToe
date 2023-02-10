package org.games;

import org.games.domains.Player;
import org.games.domains.Settings;
import org.games.enums.results.Win;
import org.games.enums.results.WinType;
import org.games.enums.settings.BoardSizes;
import org.games.enums.settings.Symbol;
import org.games.service.game.BoardService;
import org.games.win_validator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsTestSuite {
    @Test
    void testWinByRow() {
        //Given
        WinCheck winRow = new Row();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 2", true, Symbol.X.getSymbol()));
        service.enterSymbol(0, settings);
        service.enterSymbol(1, settings);
        service.enterSymbol(2, settings);
        //When
        Win win = winRow.win(settings);
        //Then
        assertEquals(WinType.ROW, win.win());
        assertEquals(2, win.start());
    }
    @Test
    void testWinByColumn() {
        //Given
        WinCheck winColumn = new Column();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 2", true, Symbol.X.getSymbol()));
        service.enterSymbol(1, settings);
        service.enterSymbol(4, settings);
        service.enterSymbol(7, settings);
        //When
        Win win = winColumn.win(settings);
        //Then
        assertEquals(WinType.COLUMN, win.win());
        assertEquals(1, win.start());
    }
    @Test
    void testWinByDiagonal() {
        //Given
        WinCheck winDiagonal = new Diagonal();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 2", true, Symbol.X.getSymbol()));
        service.enterSymbol(0, settings);
        service.enterSymbol(4, settings);
        service.enterSymbol(8, settings);
        //When
        Win win = winDiagonal.win(settings);
        //Then
        assertEquals(WinType.DIAGONAL, win.win());
        assertEquals(0, win.start());
    }
    @Test
    void testWinByDiagonalNegative() {
        //Given
        WinCheck winDiagonalNegative = new DiagonalNegative();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 2", true, Symbol.X.getSymbol()));
        service.enterSymbol(2, settings);
        service.enterSymbol(4, settings);
        service.enterSymbol(6, settings);
        //When
        Win win = winDiagonalNegative.win(settings);
        //Then
        assertEquals(WinType.DIAGONAL_NEGATIVE, win.win());
        assertEquals(2, win.start());
    }
    @Test
    void testDraw() {
        //Given
        Draw draw = new Draw();
        Settings settings = new Settings();
        BoardService service = new BoardService();
        settings.setSize(BoardSizes.SIZE_3.getBoardSize());
        settings.getBoard().createBoard(settings.getSize());
        settings.getMovesCreator().creatMoves(BoardSizes.SIZE_3.getBoardSize());
        settings.setPlayer(new Player("Player 1", true, Symbol.O.getSymbol()));
        service.enterSymbol(0, settings);
        service.enterSymbol(2, settings);
        service.enterSymbol(3, settings);
        service.enterSymbol(4, settings);
        service.enterSymbol(7, settings);
        settings.setPlayer(new Player("Player 2", true, Symbol.X.getSymbol()));
        service.enterSymbol(1, settings);
        service.enterSymbol(5, settings);
        service.enterSymbol(6, settings);
        service.enterSymbol(8, settings);
        //When
        Win win = draw.drawCheck(settings);
        //Then
        assertEquals(WinType.DRAW, win.win());
    }
}
