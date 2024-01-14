package com.genshin_javafx.controllers;

import com.genshin_javafx.entities.UserInfo;
import com.genshin_javafx.utils.AuthManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.genshin_javafx.Main;

public class SignInController {
    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button Sign_in_button;

    @FXML
    private Button Start_button;

    @FXML
    private void initialize() {
        Start_button.setOnAction(e -> Main.switchScene("Start.fxml"));
        Sign_in_button.setOnAction(e -> login());
    }
    @FXML
    private void login() {
        if (AuthManager.authenticate(login.getText(), password.getText())) {
            // Logowanie zakończone sukcesem


            Main.switchScene("Menu.fxml");
        } else {
            // Błąd logowania
            showAlert("Logowanie nieudane", "Nieprawidłowy login lub hasło.");
        }
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
