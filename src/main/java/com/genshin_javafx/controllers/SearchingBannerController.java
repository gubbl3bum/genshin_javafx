package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.utils.SearchCriteriaBanner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.Date;

public class SearchingBannerController {

    @FXML
    private Button Searching_banner_button;

    @FXML
    private Button Menu_button;

    @FXML
    private TextField name;

    @FXML
    private TextField version;

    @FXML
    private TextField character5;

    @FXML
    private TextField character4_1;

    @FXML
    private TextField character4_2;

    @FXML
    private TextField character4_3;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private void initialize(){
        Searching_banner_button.setOnAction(e -> handleSearchButton_atr());
        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }

    private void handleSearchButton_atr(){
        SearchCriteriaBanner.setName(name.getText());

        SearchCriteriaBanner.setVersion(version.getText());
        SearchCriteriaBanner.setCharacter5(character5.getText());
        SearchCriteriaBanner.setCharacter4_1(character4_1.getText());
        SearchCriteriaBanner.setCharacter4_2(character4_2.getText());
        SearchCriteriaBanner.setCharacter4_3(character4_3.getText());
        SearchCriteriaBanner.setDateStart(dateStart.getValue());
        SearchCriteriaBanner.setDateEnd(dateEnd.getValue());

        Main.switchScene("ShowBanners.fxml");
    }
}
