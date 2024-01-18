package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.utils.SearchCriteriaCharacter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchingCharacterController {

    @FXML
    private Button searching_character;

    @FXML
    private Button menu;

    @FXML
    private TextField name;

    @FXML
    private TextField element;

    @FXML
    private TextField region;

    @FXML
    private TextField gender;

    @FXML
    private TextField age;

    @FXML
    private TextField weapon;

    @FXML
    private TextField quality;

    @FXML
    private void initialize(){
        searching_character.setOnAction(e -> handleSearchButton());
        menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }

    private void handleSearchButton(){
        SearchCriteriaCharacter.setName(name.getText());
        SearchCriteriaCharacter.setElement(element.getText());
        SearchCriteriaCharacter.setRegion(region.getText());
        SearchCriteriaCharacter.setGender(gender.getText());
        SearchCriteriaCharacter.setAge(age.getText());
        SearchCriteriaCharacter.setWeapon(weapon.getText());
        SearchCriteriaCharacter.setQuality(quality.getText());

        Main.switchScene("ShowCharacters.fxml");

    }
}
