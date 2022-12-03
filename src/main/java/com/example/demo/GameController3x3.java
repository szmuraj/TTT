package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.StageStyle;

import java.util.*;

public class GameController3x3 {
    Logic3x3 gameLogic3x3 =new Logic3x3();
    public static int player = 1;
    public boolean setterController = false;
    Random random = new Random();
    private boolean turn = true;
    List<Circle> list = new ArrayList<>();
    private int draw = 0;


    @FXML
    public Line cross111;
    public Line cross112;
    public Line cross121;
    public Line cross122;
    public Line cross131;
    public Line cross132;
    public Line cross211;
    public Line cross212;
    public Line cross221;
    public Line cross222;
    public Line cross231;
    public Line cross232;
    public Line cross311;
    public Line cross312;
    public Line cross321;
    public Line cross322;
    public Line cross331;
    public Line cross332;

    public Circle circle11;
    public Circle circle12;
    public Circle circle13;
    public Circle circle21;
    public Circle circle22;
    public Circle circle23;
    public Circle circle31;
    public Circle circle32;
    public Circle circle33;


    public void onMouseClicked(Line cross, Line cross2, Circle circle) {
        if (MenuController.ai) {
            if(turn) {
                list.add(circle11);
                list.add(circle12);
                list.add(circle13);
                list.add(circle21);
                list.add(circle22);
                list.add(circle23);
                list.add(circle31);
                list.add(circle32);
                list.add(circle33);
                turn = false;
            }
            if (player == 1) {
                if (setterController) {
                    AlertHandlerWin(gameLogic3x3.verifyWhoWon());
                    player = 2;
                    cross.setOpacity(1);
                    cross2.setOpacity(1);
                    list.remove(circle);
                    draw ++;
                    if (draw == 9) {
                        drawPopUp();
                    }
                    if (!gameLogic3x3.verifyWhoWon()) {
                        circle = list.get(random.nextInt(0, list.size()));
                        circle.setOpacity(1);
                        circlePointer(circle);
                        AlertHandlerWin(gameLogic3x3.verifyWhoWon());
                        player = 1;
                        list.remove(circle);
                        draw ++;
                        if (draw == 9) {
                            AlertHandlerDraw();
                        }
                    }

                } else {
                    AlertHandlerField();
                }
            }
        } else {
            if (player == 1) {
                if (setterController) {
                    AlertHandlerWin(gameLogic3x3.verifyWhoWon());
                    player = 2;
                    cross.setOpacity(1);
                    cross2.setOpacity(1);
                    draw++;
                } else {
                    AlertHandlerField();
                }
                if(draw == 9) {
                    AlertHandlerDraw();
                }
            } else if (player == 2) {
                if (setterController) {
                    AlertHandlerWin(gameLogic3x3.verifyWhoWon());
                    player = 1;
                    circle.setOpacity(1);
                    draw++;
                } else {
                    AlertHandlerField();
                }
            }
        }
    }

    private void circlePointer( Circle circle) {
        if (circle11.equals(circle)) {
            gameLogic3x3.setValue(0, 0, 2);
        } else if (circle12.equals(circle)) {
            gameLogic3x3.setValue(0, 1, 2);
        } else if (circle13.equals(circle)) {
            gameLogic3x3.setValue(0, 2, 2);
        } else if (circle21.equals(circle)) {
            gameLogic3x3.setValue(1, 0, 2);
        } else if (circle22.equals(circle)) {
            gameLogic3x3.setValue(1, 1, 2);
        } else if (circle23.equals(circle)) {
            gameLogic3x3.setValue(1, 2, 2);
        } else if (circle31.equals(circle)) {
            gameLogic3x3.setValue(2, 0, 2);
        } else if (circle32.equals(circle)) {
            gameLogic3x3.setValue(2, 1, 2);
        } else if (circle33.equals(circle)) {
            gameLogic3x3.setValue(2, 2, 2);
        }
    }


    @FXML
    public void restart() {
        gameLogic3x3.clearBoard();
        for (Shape shape : Arrays.asList(circle11, circle12, circle13, circle21, circle22, circle23, circle31, circle32, circle33, cross111, cross112, cross121, cross122, cross131, cross132, cross211, cross212, cross221, cross222, cross231, cross232, cross311, cross312, cross321, cross322, cross331, cross332)) {
            shape.setOpacity(0);
        }
        player = 1;
    }
    @FXML
    public void menu() {
    MainController mainController = new MainController();
    mainController.loadMenuScreen();
    }

    @FXML
    public void quit() {
        System.exit(0);
    }

    @FXML
    public void onMouseClickedPane(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();
        System.out.println(x + " " + y);

        if(y>=100 && x>=75) {
            int horizontally = (int) ((y - 100) / 150);
            int perpendicularly = (int) ((x - 75) / 150);
            setterController = gameLogic3x3.setValue(horizontally, perpendicularly, player);
            if (horizontally == 0) {
                mouseClickedPane(perpendicularly, cross111, cross112, circle11, cross121, cross122, circle12, cross131, cross132, circle13);
            } else if (horizontally == 1) {
                mouseClickedPane(perpendicularly, cross211, cross212, circle21, cross221, cross222, circle22, cross231, cross232, circle23);
            } else if (horizontally == 2) {
                mouseClickedPane(perpendicularly, cross311, cross312, circle31, cross321, cross322, circle32, cross331, cross332, circle33);
            } else {
                System.out.println("Chose place to put X");
            }
        }
    }
    @FXML
    private void mouseClickedPane(int perpendicularly, Line cross111, Line cross112, Circle circle11, Line cross121, Line cross122, Circle circle12, Line cross131, Line cross132, Circle circle13) {
        if(perpendicularly==0) {
            onMouseClicked(cross111, cross112, circle11);
        } else if (perpendicularly==1) {
            onMouseClicked(cross121, cross122, circle12);
        } else if (perpendicularly==2) {
            onMouseClicked(cross131, cross132, circle13);
        } else {
            System.out.println("Chose place to put Y");
        }
    }

    public void AlertHandlerWin(boolean winnerController){
        if (winnerController){
            Alert alert = youWonPopUp();
            Platform.runLater(()->{
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get()==ButtonType.OK){restart();}
            });
        }
    }

    public void AlertHandlerField() {
        Alert alert = fieldIsNotEmpty();
        Platform.runLater(()->{
            Optional<ButtonType> result = alert.showAndWait();
        });
    }

    public void AlertHandlerDraw() {
        Alert alert = drawPopUp();
        Platform.runLater(()->{
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){restart();}
        });
    }

    private Alert youWonPopUp(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText("we have the winner!");
        alert.setGraphic(null);
        alert.setContentText("player "+(player==1 ? "1":"2")+" won");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("restart");
        turn = true;
        player = 1;
        draw = 0;
        return alert;
    }
    public Alert fieldIsNotEmpty(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText("Error");
        alert.setGraphic(null);
        alert.setContentText("This field was already taken. Pick another field.");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("OK");
        return alert;
    }
    public Alert drawPopUp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setHeaderText("Draw");
        alert.setGraphic(null);
        alert.setContentText("All fields was taken. No one win it's a draw.");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Reset");
        turn = true;
        player = 1;
        draw = 0;
        return alert;
    }
}