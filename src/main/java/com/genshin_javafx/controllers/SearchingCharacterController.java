package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaCharacter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

public class SearchingCharacterController {

    @FXML
    private Button searching_character;

    @FXML
    private Button menu;

    @FXML
    private ComboBox name;

    @FXML
    private ComboBox element;

    @FXML
    private ComboBox region;

    @FXML
    private ComboBox gender;

    @FXML
    private ComboBox age;

    @FXML
    private ComboBox weapon;

    @FXML
    private ComboBox quality;

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
//            AutoCompletionBinding<String> nameAutoCompletionBinding = TextFields.bindAutoCompletion(name.getEditor(), name.getItems());

            Query queryElement = em.createQuery("SELECT DISTINCT  c.element FROM Characters c");
            List<String> characterElement = queryElement.getResultList();
            element.setItems(FXCollections.observableArrayList(characterElement));

            Query queryRegion = em.createQuery("SELECT DISTINCT c.region FROM Characters c");
            List<String> characterRegion = queryRegion.getResultList();
            region.setItems(FXCollections.observableArrayList(characterRegion));

            Query queryGender = em.createQuery("SELECT DISTINCT c.gender FROM Characters c");
            List<String> characterGender = queryGender.getResultList();
            gender.setItems(FXCollections.observableArrayList(characterGender));

            Query queryAge = em.createQuery("SELECT DISTINCT c.age FROM Characters c");
            List<String> characterAge = queryAge.getResultList();
            age.setItems(FXCollections.observableArrayList(characterAge));

            Query queryWeapon = em.createQuery("SELECT DISTINCT c.weapon FROM Characters c");
            List<String> characterWeapon = queryWeapon.getResultList();
            weapon.setItems(FXCollections.observableArrayList(characterWeapon));

            Query queryQuality = em.createQuery("SELECT DISTINCT c.quality FROM Characters c");
            List<String> characterQuality = queryQuality.getResultList();
            quality.setItems(FXCollections.observableArrayList(characterQuality));
        }finally{
            em.close();
        }
    }
}
