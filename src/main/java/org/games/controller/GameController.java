package org.games.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.games.enums.labels.MoveSet;
import org.games.service.game.GameService;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Label playerO;
    @FXML
    private Label playerX;
    @FXML
    private Label oLabel;
    @FXML
    private Label xLabel;
    @FXML
    private Label oWinCount;
    @FXML
    private Label xWinCount;
    @FXML
    private Line winLine;
    @FXML
    private Rectangle blue;
    @FXML
    private Rectangle green;
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameService.resultInit(this);
    }

    @FXML
    private void markSquare11(ActionEvent event) {
        MoveSet set = new MoveSet(label1, button1, winLine, 0);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare12(ActionEvent event) {
        MoveSet set = new MoveSet(label2, button2, winLine, 1);
        gameService.humanMove(set);
        gameService.computerMove(this);

    }
    @FXML
    private void markSquare13(ActionEvent event) {
        MoveSet set = new MoveSet(label3, button3, winLine, 2);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare21(ActionEvent event) {
        MoveSet set = new MoveSet(label4, button4, winLine, 3);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare22(ActionEvent event) {
        MoveSet set = new MoveSet(label5, button5, winLine, 4);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare23(ActionEvent event) {
        MoveSet set = new MoveSet(label6, button6, winLine, 5);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare31(ActionEvent event) {
        MoveSet set = new MoveSet(label7, button7, winLine, 6);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare32(ActionEvent event) {
        MoveSet set = new MoveSet(label8, button8, winLine, 7);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }
    @FXML
    private void markSquare33(ActionEvent event) {
        MoveSet set = new MoveSet(label9, button9, winLine, 8);
        gameService.humanMove(set);
        gameService.computerMove(this);
    }

    public Label getLabel1() {
        return label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public Label getLabel3() {
        return label3;
    }

    public Label getLabel4() {
        return label4;
    }

    public Label getLabel5() {
        return label5;
    }

    public Label getLabel6() {
        return label6;
    }

    public Label getLabel7() {
        return label7;
    }

    public Label getLabel8() {
        return label8;
    }

    public Label getLabel9() {
        return label9;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public Button getButton3() {
        return button3;
    }

    public Button getButton4() {
        return button4;
    }

    public Button getButton5() {
        return button5;
    }

    public Button getButton6() {
        return button6;
    }

    public Button getButton7() {
        return button7;
    }

    public Button getButton8() {
        return button8;
    }

    public Button getButton9() {
        return button9;
    }

    public Label getPlayerO() {
        return playerO;
    }

    public Label getPlayerX() {
        return playerX;
    }

    public Label getoLabel() {
        return oLabel;
    }

    public Label getxLabel() {
        return xLabel;
    }

    public Label getoWinCount() {
        return oWinCount;
    }

    public Label getxWinCount() {
        return xWinCount;
    }

    public Line getWinLine() {
        return winLine;
    }

    public Rectangle getBlue() {
        return blue;
    }

    public Rectangle getGreen() {
        return green;
    }
}