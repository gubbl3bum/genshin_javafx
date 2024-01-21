package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.utils.HibernateUtil;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteRecordsController {

    @FXML
    private Button menu;

    @FXML
    private Button DeleteUser;

    @FXML
    private Button DeleteBanner;

//    @FXML
//    private Button DeleteCharacter;
//
//    @FXML
//    private JFXComboBox<String> character;

    @FXML
    private JFXComboBox<String> banner;

    @FXML
    private JFXComboBox<String> version;

    @FXML
    private JFXComboBox<String> user;
    @FXML
    private void initialize(){
        jfxComboBoxSetup();
        menu.setOnAction(e -> Main.switchScene("Menu.fxml"));
        DeleteUser.setOnAction(e -> handleDeleteUser());
        DeleteBanner.setOnAction(e -> handleDeleteBanner());
//        DeleteCharacter.setOnAction(e -> handleDeleteCharacter());
    }

    private void jfxComboBoxSetup(){
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try{
            Query queryUser = em.createQuery("SELECT DISTINCT u.login FROM UserInfo u");
            List<String> userLogins = queryUser.getResultList();
            List<String> filteredLogins = userLogins.stream()
                    .filter(login -> !login.equals("admin"))
                    .collect(Collectors.toList());
            user.setItems(FXCollections.observableArrayList(filteredLogins));
            user.setEditable(false);
//
//            Query queryCharacter = em.createQuery(
//                    "SELECT c.name FROM Characters c LEFT JOIN Banner b ON c.name = b.character5 " +
//                            "OR c.name = b.character4_1 OR c.name = b.character4_2 OR c.name = b.character4_3 " +
//                            "GROUP BY c.name HAVING COUNT(b.id) = 0"
//            );
//            List<String> characterNames = queryCharacter.getResultList();
//            character.setItems(FXCollections.observableArrayList(characterNames));
//            character.setEditable(false);

            Query queryBannerName = em.createQuery("SELECT DISTINCT b.name FROM Banner b");
            List<String> bannerNames = queryBannerName.getResultList();
            banner.setItems(FXCollections.observableArrayList(bannerNames));
            banner.setEditable(false);

            Query queryVersion = em.createQuery("SELECT DISTINCT b.version FROM Banner b");
            List<String> versionList = queryVersion.getResultList();
            version.setItems(FXCollections.observableArrayList(versionList));
            version.setEditable(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

    }

//    private void handleDeleteCharacter() {
//        String selectedCharacter = character.getSelectionModel().getSelectedItem();
//        if (selectedCharacter != null) {
//            if (isCharacterLinked(selectedCharacter)) {
//                showAlert("Can not delete character, Nie można usunąć postaci, ponieważ jest ona powiązana z innymi rekordami.");
//                return;
//            }
//            if (showConfirmationAlert("Czy na pewno chcesz usunąć postać: " + selectedCharacter + "?")) {
//                deleteCharacter(selectedCharacter);
//            }
//        }
//    }
//
//    private boolean isCharacterLinked(String characterName) {
//        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
//        try {
//            Query query = em.createQuery("SELECT COUNT(b) FROM Banner b JOIN b.characters c WHERE c.name = :characterName");
//            query.setParameter("characterName", characterName);
//            long count = (long) query.getSingleResult();
//            return count > 0;
//        } finally {
//            em.close();
//        }
//    }
//
//    private void deleteCharacter(String characterName) {
//        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
//        em.getTransaction().begin();
//        try {
//            Query query = em.createQuery("DELETE FROM Characters c WHERE c.name = :characterName");
//            query.setParameter("characterName", characterName);
//            query.executeUpdate();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//    }

    private void handleDeleteBanner() {
        String selectedBanner = banner.getSelectionModel().getSelectedItem();
        String selectedVersion = version.getSelectionModel().getSelectedItem();
        if (selectedBanner != null && selectedVersion != null) {
            if (doesBannerExistInVersion(selectedBanner, selectedVersion)) {
                if (showConfirmationAlert("Are you sure you want to remove the banner: " + selectedBanner + " from version: " + selectedVersion + "?")) {
                    deleteBanner(selectedBanner, selectedVersion);
                }
            } else {
                showAlert("Baner " + selectedBanner + " does not exist in version " + selectedVersion + ".");
            }
        }
    }
    private boolean doesBannerExistInVersion(String bannerName, String versionName) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(b) FROM Banner b WHERE b.name = :bannerName AND b.version = :versionName");
            query.setParameter("bannerName", bannerName);
            query.setParameter("versionName", versionName);
            long count = (long) query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            showAlert("Error while checking banner banner ");
            return false;
        } finally {
            em.close();
        }
    }

    private void deleteBanner(String bannerName, String versionName) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("DELETE FROM Banner b WHERE b.name = :bannerName AND b.version = :versionName");
            query.setParameter("bannerName", bannerName);
            query.setParameter("versionName", versionName);
            query.executeUpdate();
            em.getTransaction().commit();
            showConfirmationAlert("Banner successfully removed");
            Main.switchScene("Menu.fxml");
        } catch (Exception e) {
            em.getTransaction().rollback();
            showAlert("Error while removing banner");
        } finally {
            em.close();
        }
    }

    private void handleDeleteUser() {
        String selectedUser = user.getSelectionModel().getSelectedItem();
        if (selectedUser != null && showConfirmationAlert("Are you sure you want to remove user: " + selectedUser + "?")) {
            deleteUser(selectedUser);
        }
    }

    private void deleteUser(String userLogin) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("DELETE FROM UserInfo u WHERE u.login = :userLogin");
            query.setParameter("userLogin", userLogin);
            query.executeUpdate();
            em.getTransaction().commit();
            showConfirmationAlert("User successfully removed");
            Main.switchScene("Menu.fxml");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    private boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        return alert.getResult() == ButtonType.YES;
    }
}