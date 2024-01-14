package com.genshin_javafx.controllers;
import com.genshin_javafx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutMenuController {

    @FXML
    private Button Menu_button;

    @FXML
    private void initialize(){

        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
