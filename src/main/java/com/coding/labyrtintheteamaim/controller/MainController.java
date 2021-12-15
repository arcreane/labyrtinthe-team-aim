package com.coding.labyrtintheteamaim.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Button btnCommencer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnCommencer.setOnMouseClicked(changeNam ->{
            btnCommencer.setText("la partie va commencer");
        });
    }
}