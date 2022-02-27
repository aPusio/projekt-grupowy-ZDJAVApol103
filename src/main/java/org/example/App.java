package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.example.Hangman.HangmanProcessor;
import java.util.List;

import org.example.Hangman.Hangman;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("WYBIERZ OPCJE Z MENU:");
        int userOption = scanner.nextInt();
        System.out.println("USER WPISAL " + userOption);

        switch (userOption) {
            case 1:
                System.out.println("GAME 1");
                break;
            case 2:
                System.out.println("GAME 2");
                break;
            case 3:
                System.out.println("Hangman");
                HangmanProcessor hangmanProcessor = new HangmanProcessor(sessionFactory,scanner);
                hangmanProcessor.menu(scanner);
                break;
        }

        Session session = sessionFactory.openSession();

        session.close();
        sessionFactory.close();
    }
}
