package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaCharacter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;
import com.jfoenix.controls.JFXComboBox;
public class SearchingCharacterController {

    @FXML
    private Button searching_character;

    @FXML
    private Button menu;

    @FXML
    private JFXComboBox<String> name;

    @FXML
    private JFXComboBox<String> element;

    @FXML
    private JFXComboBox<String> region;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXComboBox<String> age;

    @FXML
    private JFXComboBox<String> weapon;

    @FXML
    private JFXComboBox<String> quality;

    @FXML
    private void initialize(){
        loadCharacterData();
        searching_character.setOnAction(e -> handleSearchButton());
        menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }

    private void handleSearchButton(){
        String ageValue = (String) age.getValue();
        String nameValue = (String) name.getValue();
        String elementValue = (String) element.getValue();
        String regionValue = (String) region.getValue();
        String genderValue = (String) gender.getValue();
        String weaponValue = (String) weapon.getValue();
        String qualityValue = (String) quality.getValue();

        SearchCriteriaCharacter.setName(nameValue);
        SearchCriteriaCharacter.setElement(elementValue);
        SearchCriteriaCharacter.setRegion(regionValue);
        SearchCriteriaCharacter.setGender(genderValue);
        SearchCriteriaCharacter.setAge(ageValue);
        SearchCriteriaCharacter.setWeapon(weaponValue);
        SearchCriteriaCharacter.setQuality(qualityValue);

        Main.switchScene("ShowCharacters.fxml");
    }
    private void loadCharacterData(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try{
            Query queryName = em.createQuery("SELECT DISTINCT  c.name FROM Characters c");
            List<String> characterNames = queryName.getResultList();
            name.setItems(FXCollections.observableArrayList(characterNames));
            name.setEditable(true);
            name.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterNames.stream()
                        .filter(name -> name.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                name.setItems(FXCollections.observableArrayList(filteredList));

                if (!name.isShowing()) {
                    name.show();
                }
                name.getEditor().setText(newValue);
            });
            name.setOnAction(event -> {
                String selectedName = name.getSelectionModel().getSelectedItem();
            });

            Query queryElement = em.createQuery("SELECT DISTINCT  c.element FROM Characters c");
            List<String> characterElement = queryElement.getResultList();
            element.setItems(FXCollections.observableArrayList(characterElement));
            element.setEditable(true);
            element.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterElement.stream()
                        .filter(element -> element.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                element.setItems(FXCollections.observableArrayList(filteredList));

                if (!element.isShowing()) {
                    element.show();
                }
                element.getEditor().setText(newValue);
            });
            element.setOnAction(event -> {
                String selectedElement = element.getSelectionModel().getSelectedItem();
            });

            Query queryRegion = em.createQuery("SELECT DISTINCT c.region FROM Characters c");
            List<String> characterRegion = queryRegion.getResultList();
            region.setItems(FXCollections.observableArrayList(characterRegion));
            region.setEditable(true);
            region.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterRegion.stream()
                        .filter(region -> region.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                region.setItems(FXCollections.observableArrayList(filteredList));

                if (!region.isShowing()) {
                    region.show();
                }
                region.getEditor().setText(newValue);
            });
            region.setOnAction(event -> {
                String selectedRegion = region.getSelectionModel().getSelectedItem();
            });

            Query queryGender = em.createQuery("SELECT DISTINCT c.gender FROM Characters c");
            List<String> characterGender = queryGender.getResultList();
            gender.setItems(FXCollections.observableArrayList(characterGender));
            gender.setEditable(true);
            gender.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterGender.stream()
                        .filter(gender -> gender.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                gender.setItems(FXCollections.observableArrayList(filteredList));

                if (!gender.isShowing()) {
                    gender.show();
                }
                gender.getEditor().setText(newValue);
            });
            gender.setOnAction(event -> {
                String selectedGender = gender.getSelectionModel().getSelectedItem();
            });

            Query queryAge = em.createQuery("SELECT DISTINCT c.age FROM Characters c");
            List<String> characterAge = queryAge.getResultList();
            age.setItems(FXCollections.observableArrayList(characterAge));
            age.setEditable(true);
            age.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterAge.stream()
                        .filter(age -> age.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                age.setItems(FXCollections.observableArrayList(filteredList));

                if (!age.isShowing()) {
                    age.show();
                }
                age.getEditor().setText(newValue);
            });
            age.setOnAction(event -> {
                String selectedAge = age.getSelectionModel().getSelectedItem();
            });

            Query queryWeapon = em.createQuery("SELECT DISTINCT c.weapon FROM Characters c");
            List<String> characterWeapon = queryWeapon.getResultList();
            weapon.setItems(FXCollections.observableArrayList(characterWeapon));
            weapon.setEditable(true);
            weapon.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterWeapon.stream()
                        .filter(weapon -> weapon.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                weapon.setItems(FXCollections.observableArrayList(filteredList));

                if (!weapon.isShowing()) {
                    weapon.show();
                }
                weapon.getEditor().setText(newValue);
            });
            weapon.setOnAction(event -> {
                String selectedWeapon = weapon.getSelectionModel().getSelectedItem();
            });

            Query queryQuality = em.createQuery("SELECT DISTINCT c.quality FROM Characters c");
            List<String> characterQuality = queryQuality.getResultList();
            quality.setItems(FXCollections.observableArrayList(characterQuality));
            quality.setEditable(true);
            quality.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = characterQuality.stream()
                        .filter(quality -> quality.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                quality.setItems(FXCollections.observableArrayList(filteredList));

                if (!quality.isShowing()) {
                    quality.show();
                }
                quality.getEditor().setText(newValue);
            });
            quality.setOnAction(event -> {
                String selectedWeapon = quality.getSelectionModel().getSelectedItem();
            });
        }finally{
            em.close();
        }
    }
}