package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.Banner;
import com.genshin_javafx.utils.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class ShowBannersController {

    @FXML
    private TableView<Banner> tableView;

    @FXML
    private TableColumn<Banner, Integer> idBanner;

    @FXML
    private TableColumn<Banner,String> name;

    @FXML
    private TableColumn<Banner, Date> dateStart;

    @FXML
    private TableColumn<Banner, Date> dateEnd;

    @FXML
    private TableColumn<Banner, Integer> character5;

    @FXML
    private TableColumn<Banner, Integer> character4_1;

    @FXML
    private TableColumn<Banner, Integer> character4_2;

    @FXML
    private TableColumn<Banner, Integer> character4_3;

    @FXML
    private TableColumn<Banner, Integer> version;

    @FXML
    private Button Menu;
    @FXML
    private void initialize(){
        Menu.setOnAction(e -> Main.switchScene("Menu.fxml"));

        idBanner.setCellValueFactory(new PropertyValueFactory<>("idBanner"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateStart.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
        dateEnd.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        character5.setCellValueFactory(new PropertyValueFactory<>("character5"));
        character4_1.setCellValueFactory(new PropertyValueFactory<>("character4_1"));
        character4_2.setCellValueFactory(new PropertyValueFactory<>("character4_2"));
        character4_3.setCellValueFactory(new PropertyValueFactory<>("character4_3"));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));

        loadBannerData();
    }
    private void loadBannerData() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        List<Banner> banners = em.createQuery("from Banner", Banner.class).getResultList();
        ObservableList<Banner> bannerData = FXCollections.observableArrayList(banners);
        tableView.setItems(bannerData);
    }
}
