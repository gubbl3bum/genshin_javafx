package com.genshin_javafx.controllers;

import com.genshin_javafx.entities.Characters;
import com.genshin_javafx.utils.HibernateUtil;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class AddingCharacterController {
    @FXML
    private Button Adding_char_button;

    @FXML
    private Button Menu_button;

    @FXML
    private TextField name;

    @FXML
    private JFXComboBox<String> element;

    @FXML
    private JFXComboBox<String> region;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXComboBox<String> weapon;

    @FXML
    private JFXComboBox<String> age;

    @FXML
    private TextField health;

    @FXML
    private TextField attack;

    @FXML
    private TextField defense;

    @FXML
    private TextField critRate;

    @FXML
    private TextField critDamage;

    @FXML
    private TextField elemDmgBonus;

    @FXML
    private JFXComboBox<String> quality;

    @FXML
    private void initialize(){
        jfxComboBoxInitialize();
        Adding_char_button.setOnAction(e -> addCharacter());
        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }

    private void addCharacter(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();

        Characters character = new Characters();

        character.setName(name.getText());

        String elementString = element.getValue();
        boolean elementDataBase = doesValueExistForCriteria(em,"element",elementString);
        if(elementDataBase){
            character.setElement(elementString);
        } else {
            showAlert("Element not found! Use this: Anemo, Geo, Electro, Dendro, Hydro, Pyro, Cryo!");
        }

        String regionString = region.getValue();
        boolean regionDataBase = doesValueExistForCriteria(em, "region", regionString);
        if(regionDataBase){
            character.setRegion(regionString);
        } else {
            showAlert("Region not found! Use this: Mondstadt, Liyue, Inazuma, Sumery, Fontaine, Natlan, Snezhnaya");
        }

        String genderString = gender.getValue();
        boolean genderDataBase = doesValueExistForCriteria(em, "gender", genderString);
        if(genderDataBase){
            character.setGender(genderString);
        } else {
            showAlert("Gender not found! Use this: Female, Male");
        }

        String ageString = age.getValue();
        boolean ageDataBase = doesValueExistForCriteria(em, "age", ageString);
        if(ageDataBase){
            character.setAge(ageString);
        } else {
            showAlert("Age not found! Use this: Child, Teenager, Adult");
        }

        String weaponString = weapon.getValue();
        boolean weaponDatabase = doesValueExistForCriteria(em, "weapon", weaponString);
        if(weaponDatabase){
            character.setWeapon(weaponString);
        } else {
            showAlert("Weapon not found! Use this: Sword, Bow, Claymore, Catalyst, Polearm");
        }

        String qualityString = quality.getValue();
        try{
            int qualityInt = Integer.parseInt(qualityString);
            if(qualityInt != 5 || qualityInt != 4){
                character.setQuality(qualityInt);
            } else {
                showAlert("Quality not found! Use this: 4, 5");
            }
        }catch(NumberFormatException e){
            showAlert("Error parsing quality to Integer!");
        }

        String healthString = health.getText();
        try{
            int healthInt = Integer.parseInt(healthString);
            character.setHealth(healthInt);
        }catch(NumberFormatException  e){
            showAlert("Error parsing health to Integer!");
        }

        String attackString = attack.getText();
        try{
            int attackInt = Integer.parseInt(attackString);
            character.setAttack(attackInt);
        }catch(NumberFormatException  e){
            showAlert("Error parsing attack to Integer!");
        }

        String defenseString = defense.getText();
        try{
            int defenseInt = Integer.parseInt(defenseString);
            character.setDefense(defenseInt);
        }catch(NumberFormatException  e){
            showAlert("Error parsing defense to Integer!");
        }

        String critRateString = critRate.getText();
        try{
            Double critRateDouble = Double.valueOf(critRateString);
            character.setCritRate(critRateDouble);
        }catch(NumberFormatException  e){
            showAlert("Error parsing crtitical damage rate to Double!");
        }

        String critDamageString = critDamage.getText();
        try{
            Double critDamageDouble = Double.valueOf(critDamageString);
            character.setCritDamage(critDamageDouble);
        }catch(NumberFormatException  e){
            showAlert("Error parsing critical damage to Double!");
        }

        String elDmgBonString = elemDmgBonus.getText();
        try{
            Double elemenDmgBonDouble = Double.valueOf(elDmgBonString);
            character.setElemenDmgBonus(elemenDmgBonDouble);
        }catch(NumberFormatException  e){
            showAlert("Error parsing elemental damage bonus to Double!");
        }

        try{
            em.getTransaction().begin();
            em.persist(character);
            em.getTransaction().commit();
            em.close();
            Main.switchScene("AddedCharacter.fxml");
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        } finally{
            em.close();
        }

    }

//    private Object findCriteria(EntityManager em, String criteria, String thing) {
//        try {
//            return em.createQuery("SELECT c FROM Characters c WHERE c.criteria = :thing")
//                    .setParameter("criteria", criteria).setParameter("thing", thing)
//                    .getSingleResult();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    private Object findCriteria(EntityManager em, String criteria, String value) {
//        try {
//            String queryString = String.format("SELECT c FROM Characters c WHERE c.%s = :value", criteria);
//            return em.createQuery(queryString, Characters.class)
//                    .setParameter("value", value)
//                    .getSingleResult();
//        } catch (Exception e) {
//            // Log or handle exception as needed
//            return null;
//        }
//    }

    private Characters findCharacterByAttribute(EntityManager em, String attributeName, String value) {
        try {
            // Użyj bezpośrednio nazwy atrybutu z klasy, bez formatowania zapytania
            String queryString = "SELECT DISTINCT c FROM Characters c WHERE c." + attributeName + " = :value";
            return em.createQuery(queryString, Characters.class)
                    .setParameter("value", value)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Nie znaleziono wyników, zwróć null lub obsłuż odpowiednio
            return null;
        } catch (Exception e) {
            // Loguj inne wyjątki, które mogą wskazywać na problemy z zapytaniem lub bazą danych
            e.printStackTrace();
            return null;
        }
    }

    private boolean doesValueExistForCriteria(EntityManager em, String criteria, String value) {
        String queryString = "SELECT COUNT(c) FROM Characters c WHERE c." + criteria + " = :value";
        Long count = em.createQuery(queryString, Long.class)
                .setParameter("value", value)
                .getSingleResult();
        return count > 0;
    }



    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
    private void jfxComboBoxInitialize(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try{
            Query queryElement = em.createQuery("SELECT c.element FROM Characters c");
            List<String> elementList = queryElement.getResultList();
            element.setItems(FXCollections.observableArrayList(elementList));
            element.setEditable(true);

            element.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = elementList.stream()
                        .filter(element -> element.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                element.setItems(FXCollections.observableArrayList(filteredList));

                if (!element.isShowing()) {
                    element.show();
                }
                element.getEditor().setText(newValue);
            });

            Query queryRegion = em.createQuery("SELECT c.region FROM Characters c");
            List<String> regionList = queryRegion.getResultList();
            region.setItems(FXCollections.observableArrayList(regionList));
            region.setEditable(true);

            region.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = regionList.stream()
                        .filter(region -> region.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                region.setItems(FXCollections.observableArrayList(filteredList));

                if (!region.isShowing()) {
                    region.show();
                }
                region.getEditor().setText(newValue);
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
        }catch(Exception e){

        }finally{
            em.close();
        }
    }
}