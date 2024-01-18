package com.genshin_javafx.services;

import com.genshin_javafx.entities.Characters;
import com.genshin_javafx.utils.HibernateUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class CharacterService {

    public List<String> getCharacterNamesFromDatabase() {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            List<String> characterNames = em.createQuery("SELECT c.name FROM Characters c", String.class).getResultList();
            em.getTransaction().commit();
            return characterNames;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}