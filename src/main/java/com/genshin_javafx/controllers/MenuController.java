package com.genshin_javafx.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;


public class MenuController {

    @FXML
    private Button Search_char_button;

    @FXML
    private Button Search_banners_button;

    @FXML
    private Button Sign_out_button;

    @FXML
    private Button Add_char_button;

    @FXML
    private Button Add_banner_button;

    @FXML
    private Button About_button;

    @FXML
    private void initialize(){
        Search_char_button.setOnAction(e -> Main.switchScene("SearchingCharacter.fxml"));
        Search_banners_button.setOnAction(e -> Main.switchScene("SearchingBanner.fxml"));
        Sign_out_button.setOnAction(e -> Main.switchScene("Start.fxml"));
        Add_char_button.setOnAction(e -> Main.switchScene("AddingCharacter.fxml"));
        Add_banner_button.setOnAction(e -> Main.switchScene("AddingBanner.fxml"));
        About_button.setOnAction(e -> Main.switchScene("AboutMenu.fxml"));
    }

}
