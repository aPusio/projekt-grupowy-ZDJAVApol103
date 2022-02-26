package org.example.Ships;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class ShipsProcessor {

    HibernateFactory hibernateFactory = new HibernateFactory();
    SessionFactory sessionFactory = hibernateFactory.getSessionFactory();

    void dodaj(String login, String haslo) {

        try (
                Session session = SDA_SESSION_FACTORY.openSession()) {
            //zapisywanie nowego bibliotekarza:
            Bibliotekarz bibliotekarz = new Bibliotekarz();
            bibliotekarz.setHaslo(haslo);
            bibliotekarz.setLogin(login);
            Serializable id = session.save(bibliotekarz);
            log.info("Saved new entity (bibliotekarz) with id: {}", id);
        }
}
