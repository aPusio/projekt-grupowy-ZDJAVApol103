package org.example.Hangman;

import org.hibernate.SessionFactory;

public class PlayerProcessor {

    private SessionFactory sessionFactory;
    public PlayerProcessor(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }
}
