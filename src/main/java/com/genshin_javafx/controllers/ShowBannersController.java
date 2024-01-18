package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.Banner;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.SearchCriteriaBanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
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
    private TableColumn<Banner, String > character5;

    @FXML
    private TableColumn<Banner, String> character4_1;

    @FXML
    private TableColumn<Banner, String> character4_2;

    @FXML
    private TableColumn<Banner, String> character4_3;

    @FXML
    private TableColumn<Banner, Integer> version;

    @FXML
    private Button Menu;
    @FXML
    private void initialize() {
        Menu.setOnAction(e -> Main.switchScene("Menu.fxml"));

        idBanner.setCellValueFactory(new PropertyValueFactory<>("idBanner"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateStart.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
        dateEnd.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        //wyświetlanie nazw z tablicy characters
        character5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCharacter5().getName()));
        character4_1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCharacter4_1().getName()));
        character4_2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCharacter4_2().getName()));
        character4_3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCharacter4_3().getName()));
        version.setCellValueFactory(new PropertyValueFactory<>("version"));

        loadBannerData();
    }
    private void loadBannerData(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        String name = SearchCriteriaBanner.getName();
        String version = SearchCriteriaBanner.getVersion();
        String character5 = SearchCriteriaBanner.getCharacter5();
        String character4_1 = SearchCriteriaBanner.getCharacter4_1();
        LocalDate startDate = SearchCriteriaBanner.getDateStart();
        LocalDate endDate = SearchCriteriaBanner.getDateEnd();
        LocalDate dateBetween = SearchCriteriaBanner.getDateBetween();

        StringBuilder queryString = new StringBuilder("from Banner b where 1=1");

        if (name != null && !name.isEmpty()) {
            queryString.append(" and b.name like :name");
        }
        if (version != null && !version.isEmpty()) {
            queryString.append(" and b.version like :version");
        }
        if(character5 != null && !character5.isEmpty()){
            queryString.append(" and b.character5.name like :character5");
        }
        if(character4_1 != null && !character4_1.isEmpty()){
            queryString.append(" and (b.character4_1.name like :character4_1 or b.character4_2.name like :character4_1 or b.character4_3.name like :character4_1)");
        }

        if (startDate != null) {
            queryString.append(" and b.dateStart >= :startDate");
        }
        if (endDate != null) {
            queryString.append(" and b.dateEnd <= :endDate");
        }
        if (dateBetween != null){
            queryString.append(" and (b.dateStart <= :dateBetween and b.dateEnd >= :dateBetween)");
        }

        Query query = em.createQuery(queryString.toString(), Banner.class);

        // ustawianie parametru wyszukiwań
        if (name != null && !name.isEmpty()) {
            query.setParameter("name", "%" + name + "%");
        }
        if (version != null && !version.isEmpty()) {
            query.setParameter("version", version);
        }
        if(character5 != null && !character5.isEmpty()){
            query.setParameter("character5", character5);
        }
        if(character4_1 != null && !character4_1.isEmpty()){
            query.setParameter("character4_1", character4_1);
        }
        if (startDate != null) {
            Date dateStart = SearchCriteriaBanner.asDate(startDate);
            query.setParameter("startDate", dateStart);
        }
        if (endDate != null) {
            Date dateEnd = SearchCriteriaBanner.asDate(endDate);
            query.setParameter("endDate", dateEnd);
        }
        if (dateBetween != null) {
            Date betweenDate = SearchCriteriaBanner.asDate(dateBetween);
            query.setParameter("dateBetween", betweenDate);
        }

        List<Banner> banners = query.getResultList();

        ObservableList<Banner> bannerData = FXCollections.observableArrayList(banners);
        tableView.setItems(bannerData);
    }
}
