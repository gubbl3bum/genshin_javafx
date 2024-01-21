package com.genshin_javafx.utils;

import com.genshin_javafx.entities.UserInfo;
import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.EntityManager;

public class AuthManager {
//    public static boolean authenticate(String login, String password) {
//        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
//        try {
//            UserInfo user = em.createQuery(
//                            "SELECT u FROM UserInfo u WHERE u.login = :login", UserInfo.class)
//                    .setParameter("login", login)
//                    .getSingleResult();
//            return user != null && BCrypt.checkpw(password, user.getPassword());
//        } catch (Exception e) {
//            return false;
//        } finally {
//            em.close();
//        }
//    }
public static boolean authenticate(String login, String password) {
    EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
    try {
        UserInfo user = em.createQuery("SELECT u FROM UserInfo u WHERE u.login = :login", UserInfo.class)
                .setParameter("login", login)
                .getSingleResult();
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            Session.setCurrentUser("login");
            return true;
        }
    } catch (Exception e) {
        return false;
    } finally {
        em.close();
    }
    return false;
}

}
