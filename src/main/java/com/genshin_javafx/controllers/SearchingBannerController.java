package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class SearchingBannerController {

    @FXML
    private Button Searching_banner_button;

    @FXML
    private Button Menu_button;

    @FXML
    private void initialize(){
        Searching_banner_button.setOnAction(e -> Main.switchScene("ShowBanners.fxml"));
        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
