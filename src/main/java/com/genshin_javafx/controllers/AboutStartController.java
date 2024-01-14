package com.genshin_javafx.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;

public class AboutStartController {

    @FXML
    private Button Start_button;

    @FXML
    private void initialize(){

        Start_button.setOnAction(e -> Main.switchScene("Start.fxml"));
    }
}
