package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    public boolean ai = true;
    private MainController mainController;

    @FXML
    public void pve() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PvP.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainController.setScreen(pane);
    }

    @FXML
    public void pvp() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PvP.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
