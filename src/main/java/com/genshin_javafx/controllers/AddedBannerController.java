package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddedBannerController {
    @FXML
    private Button menu;
    @FXML
    private void initialize(){
        menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
