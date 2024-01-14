package com.genshin_javafx.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;


public class AddingBannerController {

    @FXML
    private Button Adding_banner;

    @FXML
    private Button Menu;

    @FXML
    private void initialize() {
        Adding_banner.setOnAction(e -> Main.switchScene("Menu.fxml"));
        Menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
