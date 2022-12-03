package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import static com.example.demo.GameController3x3.player;

public class GameController10x10 {
    private double x = 0;
    private double y = 0;

    @FXML
    public void onMouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if(player==1) {
            cross(x,y);
        } else {
            circle(x,y);
        }
    }
    @FXML
    public void cross(double x, double y) {

    }
    @FXML
    public void circle(double x, double y) {
    }
    @FXML
    public void restart() {

    }

    @FXML
    public void menu() {

    }

    @FXML
    public void quit() {
        System.exit(0);
    }
}
