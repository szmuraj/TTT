package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    public static boolean ai = false;
    private MainController mainController;

    @FXML
    public void pve() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game10x10.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ai = true;
        mainController.setScreen(pane);
    }

    @FXML
    public void pvp() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Game3x3.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ai = false;
        mainController.setScreen(pane);
    }

    @FXML
    public void quit() {
        System.exit(0);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
