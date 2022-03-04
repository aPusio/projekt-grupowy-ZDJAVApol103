package org.example.factoring;


import org.example.arraysCreating.Paair;
import org.example.arraysCreating.SaveTheGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;

public  class ReadingTheGame {

    public static List<SaveTheGame> StatesOfTheGame(){
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<SaveTheGame> id = session.createQuery("FROM SaveTheGame ORDER BY id", SaveTheGame.class).getResultList();
        session.close();
        sessionFactory.close();
        return id;
    }

    public static List<Paair> ReadTheStateOfTheGame(int state) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Paair> from_paair = session.createQuery("FROM Paair WHERE saveTheGame_id = :id", Paair.class)
                .setParameter("id", state).getResultList();
        session.close();
        sessionFactory.close();
        return from_paair;
    }
    public static void LoadGameState(List<Paair> listpaair) {
        HibernateFactory hibernateFactory = new HibernateFactory();
         SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        SaveTheGame saveTheGame = new SaveTheGame();
        saveTheGame.setLocalDateTime(LocalDateTime.now());
        saveTheGame.setListPaair(listpaair);
        session.save(saveTheGame);
        for(Paair paair: listpaair) {
            paair.setSaveTheGame(saveTheGame);
            session.save(paair);
        }
        session.close();
        sessionFactory.close();
    }
}
