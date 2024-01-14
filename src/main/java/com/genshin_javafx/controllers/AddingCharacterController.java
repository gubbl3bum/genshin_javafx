package com.genshin_javafx.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;
public class AddingCharacterController {

    @FXML
    private Button Adding_char_button;

    @FXML
    private Button Menu_button;

    @FXML
    private void initialize(){
        Adding_char_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
