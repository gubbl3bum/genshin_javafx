package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.Characters;
import com.genshin_javafx.utils.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ShowCharactersController {
    @FXML
    private TableView<Characters> tableView;

    @FXML
    private TableColumn<Characters, Integer> id;

    @FXML
    private TableColumn<Characters, String> name;

    @FXML
    private TableColumn<Characters, String> element;

    @FXML
    private TableColumn<Characters, String> region;

    @FXML
    private TableColumn<Characters, String> gender;

    @FXML
    private TableColumn<Characters, String> age;

    @FXML
    private TableColumn<Characters, String> weapon;

    @FXML
    private TableColumn<Characters, Integer> health;

    @FXML
    private TableColumn<Characters, Integer> attack;

    @FXML
    private TableColumn<Characters, Integer> defense;

    @FXML
    private TableColumn<Characters, Double> critRate;

    @FXML
    private TableColumn<Characters, Double> critDamage;

    @FXML
    private TableColumn<Characters, Integer> quality;

    @FXML
    private TableColumn<Characters, Double> elemenDmgBonus;

    @FXML
    private Button Menu;

    @FXML
    private void initialize(){
        Menu.setOnAction(e -> Main.switchScene("Menu.fxml"));

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        element.setCellValueFactory(new PropertyValueFactory<>("element"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        weapon.setCellValueFactory(new PropertyValueFactory<>("weapon"));
        attack.setCellValueFactory(new PropertyValueFactory<>("attack"));
        defense.setCellValueFactory(new PropertyValueFactory<>("defense"));
        critRate.setCellValueFactory(new PropertyValueFactory<>("critRate"));
        critDamage.setCellValueFactory(new PropertyValueFactory<>("critDamage"));
        quality.setCellValueFactory(new PropertyValueFactory<>("quality"));
        elemenDmgBonus.setCellValueFactory(new PropertyValueFactory<>("elemenDmgBonus"));

        loadCharacterData();
    }
    private void loadCharacterData(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        List<Characters> characters = em.createQuery("from Character",Characters.class).getResultList();
        ObservableList<Characters> charactersData = FXCollections.observableArrayList(characters);
        tableView.setItems(charactersData);
    }
}
