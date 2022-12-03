package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GameTypeController {
    MainController mainController = new MainController();

    @FXML
    public void type10x10() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game10x10.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainController.setScreen(pane);
    }

    @FXML
    public void type3x3() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game3x3.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainController.setScreen(pane);
    }

    @FXML
    public void menu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void quit() {
        System.exit(0);
    }
}
