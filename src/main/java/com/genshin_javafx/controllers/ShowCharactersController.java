package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.Characters;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaCharacter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        weapon.setCellValueFactory(new PropertyValueFactory<>("weapon"));
        health.setCellValueFactory(new PropertyValueFactory<>("health"));
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
        String name = SearchCriteriaCharacter.getName();
        String element = SearchCriteriaCharacter.getElement();
        String region = SearchCriteriaCharacter.getRegion();
        String gender = SearchCriteriaCharacter.getGender();
        String age = SearchCriteriaCharacter.getAge();
        String weapon = SearchCriteriaCharacter.getWeapon();
        String qualityString = SearchCriteriaCharacter.getQuality();

        Integer quality = null;
        if(qualityString != null && !qualityString.isEmpty()){
            try{
                quality = Integer.parseInt(qualityString);
            } catch (NumberFormatException e){
                //błąd formatowania
            }
        }

        StringBuilder queryString = new StringBuilder("from Characters c where 1=1");

        if(name != null && !name.isEmpty()){
            queryString.append(" and c.name like :name");
        }
        if(element != null && !element.isEmpty()){
            queryString.append(" and c.element like :element");
        }
        if(region != null && !region.isEmpty()){
            queryString.append(" and c.region like :region");
        }
        if(gender != null && !gender.isEmpty()){
            queryString.append(" and c.gender like :gender");
        }
        if(age != null && !age.isEmpty()){
            queryString.append(" and c.age like :age");
        }
        if(weapon != null && !weapon.isEmpty()){
            queryString.append(" and c.weapon like :weapon");
        }
        if(quality != null){
            queryString.append(" and c.quality like :quality");
        }

        Query query = em.createQuery(queryString.toString(), Characters.class);

        //ustawienie parametrów wyszukiwań

        if(name != null && !name.isEmpty()){
            query.setParameter("name", name);
        }
        if(element != null && !element.isEmpty()){
            query.setParameter("element", element);
        }
        if(region != null && !region.isEmpty()){
            query.setParameter("region", region);
        }
        if(gender != null && !gender.isEmpty()){
            query.setParameter("gender", gender);
        }
        if(age != null && !age.isEmpty()){
            query.setParameter("age", age);
        }
        if(weapon != null && !weapon.isEmpty()){
            query.setParameter("weapon", weapon);
        }
        if(quality != null){
            query.setParameter("quality", quality);
        }

        List<Characters> characters = query.getResultList();

        ObservableList<Characters> characterData = FXCollections.observableArrayList(characters);
        tableView.setItems(characterData);

    }
}
