package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.UserInfo;
import com.genshin_javafx.utils.HibernateUtil;
import com.genshin_javafx.utils.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class SignUpController {

    @FXML
    private Button Sign_up_button;

    @FXML
    private Button Start_button;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    private void initialize() {
        Sign_up_button.setOnAction(e -> register());
        Start_button.setOnAction(e -> Main.switchScene("Start.fxml"));
    }

    private void register() {
        if (!password1.getText().equals(password2.getText())) {
            showAlert("Passwords do not match!");
            return;
        }
        String hashedPassword = BCrypt.hashpw(password1.getText(), BCrypt.gensalt());

        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            UserInfo existingUser = em.createQuery("SELECT u FROM UserInfo u WHERE u.login = :login", UserInfo.class)
                    .setParameter("login", login.getText())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (existingUser != null) {
                showAlert("User with this login already exists!");
                return;
            }

            UserInfo newUser = new UserInfo();
            newUser.setLogin(login.getText());
            newUser.setPassword(hashedPassword);
            newUser.setRole("user");

            em.persist(newUser);
            em.getTransaction().commit();
            Session.setCurrentUser("user");
            Main.switchScene("Menu.fxml");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
