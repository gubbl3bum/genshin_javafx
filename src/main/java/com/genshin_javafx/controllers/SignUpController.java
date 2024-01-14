package com.genshin_javafx.controllers;

import com.genshin_javafx.Main;
import com.genshin_javafx.entities.UserInfo;
import com.genshin_javafx.utils.HibernateUtil;
import javafx.fxml.FXML;
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
            // hasła muszą być równe
            return;
        }
        String hashedPassword = BCrypt.hashpw(password1.getText(), BCrypt.gensalt());

        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            UserInfo newUser = new UserInfo();
            newUser.setLogin(login.getText());
            newUser.setPassword(hashedPassword);

            em.persist(newUser);
            em.getTransaction().commit();

            //rejestracja udana, przejście do menu
            Main.switchScene("Menu.fxml");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            // Obsługa błędu
        } finally {
            em.close();
        }
    }
}
