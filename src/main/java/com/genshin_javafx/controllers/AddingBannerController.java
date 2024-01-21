package com.genshin_javafx.controllers;

import com.genshin_javafx.entities.Banner;
import com.genshin_javafx.entities.Characters;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaBanner;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import com.genshin_javafx.Main;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AddingBannerController {

    @FXML
    private Button Adding_banner;

    @FXML
    private Button Menu;

    @FXML
    private JFXComboBox<String> name;

    @FXML
    private JFXComboBox<String> version;

    @FXML
    private JFXComboBox<String> character5;

    @FXML
    private JFXComboBox<String> character4_1;

    @FXML
    private JFXComboBox<String> character4_2;

    @FXML
    private JFXComboBox<String> character4_3;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateEnd;

    private final LocalDate minimalDate = LocalDate.of(2020, 9, 28);

    private List<String> combinedList = new ArrayList<>();

    private ChangeListener<String> character4_1Listener;
    private ChangeListener<String> character4_2Listener;
    private ChangeListener<String> character4_3Listener;

    @FXML
    private void initialize() {
        addListeners();
        jfxcomboboxInitialize();
        setupDatePicker();
        Adding_banner.setOnAction(e -> addBanner());
        Menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }

    private void addListeners(){
        character4_1Listener = (observable, oldValue, newValue) -> {
            if (!Objects.equals(oldValue, newValue)) {
                validateCharacterSelection();
            }
        };
        character4_2Listener = (observable, oldValue, newValue) -> {
            if (!Objects.equals(oldValue, newValue)) {
                validateCharacterSelection();
            }
        };
        character4_3Listener = (observable, oldValue, newValue) -> {
            if (!Objects.equals(oldValue, newValue)) {
                validateCharacterSelection();
            }
        };
    }
    private void jfxcomboboxInitialize(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try{
            Query queryName = em.createQuery("SELECT DISTINCT  b.name FROM Banner b");
            List<String> bannerNames = queryName.getResultList();
            name.setItems(FXCollections.observableArrayList(bannerNames));
            name.setEditable(true);
            name.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = bannerNames.stream()
                        .filter(name -> name.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                name.setItems(FXCollections.observableArrayList(filteredList));

                if (!name.isShowing()) {
                    name.show();
                }
                name.getEditor().setText(newValue);
            });

            Query versionName = em.createQuery("SELECT DISTINCT  b.version FROM Banner b");
            List<String> versionList = versionName.getResultList();
            version.setItems(FXCollections.observableArrayList(versionList));
            version.setEditable(true);
            version.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = versionList.stream()
                        .filter(version -> version.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                version.setItems(FXCollections.observableArrayList(filteredList));

                if (!version.isShowing()) {
                    version.show();
                }
                version.getEditor().setText(newValue);
            });

            Query queryChar5 = em.createQuery("SELECT DISTINCT char5.name FROM Banner b JOIN b.character5 char5");
            List<String> character5List = queryChar5.getResultList();
            character5.setItems(FXCollections.observableArrayList(character5List));
            character5.setEditable(true);
            character5.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = character5List.stream()
                        .filter(character5 -> character5.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                character5.setItems(FXCollections.observableArrayList(filteredList));

                if (!character5.isShowing()) {
                    character5.show();
                }
                character5.getEditor().setText(newValue);
            });

            Query queryChar4_1 = em.createQuery("SELECT DISTINCT char4_1.name FROM Banner b JOIN b.character4_1 char4_1");
            Query queryChar4_2 = em.createQuery("SELECT DISTINCT char4_2.name FROM Banner b JOIN b.character4_2 char4_2");
            Query queryChar4_3 = em.createQuery("SELECT DISTINCT char4_3.name FROM Banner b JOIN b.character4_3 char4_3");

            List<String> character4_1List = queryChar4_1.getResultList();
            List<String> character4_2List = queryChar4_2.getResultList();
            List<String> character4_3List = queryChar4_3.getResultList();

            Set<String> combinedSet = new HashSet<>();
            combinedSet.addAll(character4_1List);
            combinedSet.addAll(character4_2List);
            combinedSet.addAll(character4_3List);

            combinedList = new ArrayList<>(combinedSet);

            character4_1.setItems(FXCollections.observableArrayList(combinedList));
            character4_1.setEditable(true);
            character4_1.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = combinedList.stream()
                        .filter(character4_1 -> character4_1.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                character4_1.setItems(FXCollections.observableArrayList(filteredList));

                if (!character4_1.isShowing()) {
                    character4_1.show();
                }
                character4_1.getEditor().setText(newValue);
            });

            character4_2.setItems(FXCollections.observableArrayList(combinedList));
            character4_2.setEditable(true);
            character4_2.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = combinedList.stream()
                        .filter(character4_2 -> character4_2.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                character4_2.setItems(FXCollections.observableArrayList(filteredList));

                if (!character4_2.isShowing()) {
                    character4_2.show();
                }
                character4_2.getEditor().setText(newValue);
            });

            character4_3.setItems(FXCollections.observableArrayList(combinedList));
            character4_3.setEditable(true);
            character4_3.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                List<String> filteredList = combinedList.stream()
                        .filter(character4_3 -> character4_3.toLowerCase().startsWith(newValue.toLowerCase()))
                        .collect(Collectors.toList());

                character4_3.setItems(FXCollections.observableArrayList(filteredList));

                if (!character4_3.isShowing()) {
                    character4_3.show();
                }
                character4_3.getEditor().setText(newValue);
            });

        } catch(Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            showAlert("An error occured while adding the banner" + e.getMessage());
        } finally {
            em.close();
        }
    }

    private void validateCharacterSelection() {
        String char4_1 = character4_1.getSelectionModel().getSelectedItem();
        String char4_2 = character4_2.getSelectionModel().getSelectedItem();
        String char4_3 = character4_3.getSelectionModel().getSelectedItem();

        if (char4_1 != null && char4_1.equals(char4_2) && char4_1.equals(char4_3)) {
            // Wyświetl komunikat o błędzie
            showAlert("Nie można wybrać trzech takich samych postaci 4*.");
            // Możesz również zresetować wybory w ComboBoxach
            // Zresetuj wybory w ComboBoxach
            character4_1.getSelectionModel().clearSelection();
            character4_2.getSelectionModel().clearSelection();
            character4_3.getSelectionModel().clearSelection();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
    private void addBanner() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();

        Banner banner = new Banner();
        banner.setName(name.getValue());

        String valueString = version.getValue();
        if (valueString != null && valueString.matches("\\d+\\.\\d+")) {
            banner.setVersion(valueString);
        } else {
            showAlert("Wrong version! Use 'X.Y' format where X and Y are numbers.");
        }

        String character5Name = (String) character5.getValue(); // Załóżmy, że masz TextField do wprowadzenia nazwy postaci 5*
        Characters character5Char = findCharacterByName(em, character5Name);
        if (character5Char != null) {
            banner.setCharacter5(character5Char);
        } else {
            showAlert("Character 5* not found!");
        }
        String character4_1Name = (String) character4_1.getValue(); // Załóżmy, że masz TextField do wprowadzenia nazwy postaci 5*
        Characters character4_1Char = findCharacterByName(em, character4_1Name);
        if (character4_1Char != null) {
            banner.setCharacter4_1(character4_1Char);
        } else {
            showAlert("Character 4_1* not found!");
        }
        String character4_2Name = (String) character4_2.getValue(); // Załóżmy, że masz TextField do wprowadzenia nazwy postaci 5*
        Characters character4_2Char = findCharacterByName(em, character4_2Name);
        if (character4_2Char != null) {
            banner.setCharacter4_2(character4_2Char);
        } else {
            showAlert("Character 4_2* not found!");
        }
        String character4_3Name = (String) character4_3.getValue(); // Załóżmy, że masz TextField do wprowadzenia nazwy postaci 5*
        Characters character4_3Char = findCharacterByName(em, character4_3Name);
        if (character4_3Char != null) {
            banner.setCharacter4_3(character4_3Char);
        } else {
            showAlert("Character 4_3* not found!");
        }
        banner.setDateStart(SearchCriteriaBanner.asDate(dateStart.getValue()));
        banner.setDateEnd(SearchCriteriaBanner.asDate(dateEnd.getValue()));

        em.getTransaction().begin();
        em.persist(banner);
        em.getTransaction().commit();
        em.close();
        Main.switchScene("AddedBanner.fxml");
    }

    private Characters findCharacterByName(EntityManager em, String name) {
        try {
            return em.createQuery("SELECT c FROM Characters c WHERE c.name = :name", Characters.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            // Obsługa wyjątku, na przykład gdy postać nie istnieje
            return null;
        }
    }
    public void setupDatePicker() {
        Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (item.isBefore(minimalDate)) {
                    this.setDisable(true);
                }
            }
        };
        dateStart.setDayCellFactory(dayCellFactory);

        dateStart.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null) {
                dateEnd.setDayCellFactory(d -> new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(newDate)) {
                            this.setDisable(true);
                        }
                    }
                });
            }
        });
    }
}