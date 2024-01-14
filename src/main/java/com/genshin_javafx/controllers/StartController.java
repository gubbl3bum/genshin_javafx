package com.genshin_javafx.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;


public class StartController {

    @FXML
    private Button Sign_in_button;

    @FXML
    private Button Sign_up_button;

    @FXML
    private Button About_button;

    @FXML
    private Button Sign_in_guest;

    @FXML
    private void initialize() {
        Sign_in_button.setOnAction(e -> Main.switchScene("SignIn.fxml"));
        Sign_up_button.setOnAction(e -> Main.switchScene("SignUp.fxml"));
        About_button.setOnAction(e -> Main.switchScene("AboutStart.fxml"));
        Sign_in_guest.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
}
