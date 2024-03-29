package com.genshin_javafx.controllers;
import com.genshin_javafx.entities.UserInfo;
import com.genshin_javafx.utils.Session;
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
    private Button Delete_records;
    @FXML
    private void initialize(){
        String currentUser = Session.getCurrentUser();
        if(currentUser.equals("guest")){
            Add_banner_button.setVisible(false);
            Add_char_button.setVisible(false);
        } else {
            Add_char_button.setOnAction(e -> Main.switchScene("AddingCharacter.fxml"));
            Add_banner_button.setOnAction(e -> Main.switchScene("AddingBanner.fxml"));
        }
        Delete_records.setVisible(false);
        Search_char_button.setOnAction(e -> Main.switchScene("SearchingCharacter.fxml"));
        Search_banners_button.setOnAction(e -> Main.switchScene("SearchingBanner.fxml"));
        Sign_out_button.setOnAction(e -> signOut());
        About_button.setOnAction(e -> Main.switchScene("AboutMenu.fxml"));
        if(currentUser.equals("admin")){
            Delete_records.setVisible(true);
        }
        Delete_records.setOnAction(e -> Main.switchScene("DeleteRecords.fxml"));
    }

    private void signOut(){
        Session.setCurrentUser("guest");
        Main.switchScene("Start.fxml");
    }
}
