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

    void dodaj(int length,  int xStart, int xEnd, int  yStart, int yEnd, int hits) {

        try (
                Session session = sessionFactory.openSession()) {
            //zapisywanie nowego statku:
            ShipsEntity ships = new ShipsEntity();
            ships.setShipLength(length);
            ships.setXEndPoint(xEnd);
            ships.setYEndPoint(yEnd);
            ships.setXStartPoint(xStart);
            ships.setYStartPoint(yStart);
            ships.setHits(hits);
            Serializable id = session.save(ships);
            log.info("Saved new entity (ships) with id: {}", id);
        }
    }
}


