package com.genshin_javafx.controllers;
import com.genshin_javafx.Main;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaBanner;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchingBannerController {

    @FXML
    private Button Searching_banner_button;

    @FXML
    private Button Menu_button;

    @FXML
    private JFXComboBox<String> name;

    @FXML
    private JFXComboBox<String> version;

    @FXML
    private JFXComboBox<String> character5;

    @FXML
    private JFXComboBox<String> character4_1;

    @FXML
    private DatePicker dateBetween;

    @FXML
    private DatePicker dateStart;

    @FXML
    private DatePicker dateEnd;

    private final LocalDate minimalDate = LocalDate.of(2020,9,28);

    @FXML
    private void initialize(){
        loadCharacterData_B();
        setupDatePicker();
        Searching_banner_button.setOnAction(e -> handleSearchButton_atr());
        Menu_button.setOnAction(e -> Main.switchScene("Menu.fxml"));
    }
    private void handleSearchButton_atr(){
        String nameValue = (String) name.getValue();
        String versionValue = (String) version.getValue();
        String char5Value = (String) character5.getValue();
        String char4Value = (String) character4_1.getValue();

        SearchCriteriaBanner.setName(nameValue);
        SearchCriteriaBanner.setVersion(versionValue);
        SearchCriteriaBanner.setCharacter5(char5Value);
        SearchCriteriaBanner.setCharacter4_1(char4Value);
        SearchCriteriaBanner.setDateBetween(dateBetween.getValue());
        SearchCriteriaBanner.setDateStart(dateStart.getValue());
        SearchCriteriaBanner.setDateEnd(dateEnd.getValue());

        Main.switchScene("ShowBanners.fxml");
    }
    private void loadCharacterData_B(){
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
            name.setOnAction(event -> {
                String selectedName = name.getSelectionModel().getSelectedItem();
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
            version.setOnAction(event -> {
                String selectedVersion = version.getSelectionModel().getSelectedItem();
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
            character5.setOnAction(event -> {
                String selecedChar5 = character5.getSelectionModel().getSelectedItem();
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

            List<String> combinedList = new ArrayList<>(combinedSet);
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
            character4_1.setOnAction(event -> {
                String selectedchar4 = character4_1.getSelectionModel().getSelectedItem();
            });

        }finally{
            em.close();
        }
    }
    private void setupDatePicker(){
        // Ustawienie minimalnej daty dla dateStart i dateBetween
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
        dateBetween.setDayCellFactory(dayCellFactory);

        // Aktualizacja ograniczeń dla dateEnd na podstawie wybranej wartości w dateStart
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
