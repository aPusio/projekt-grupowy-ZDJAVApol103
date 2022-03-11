package org.example;

import org.example.game2048.Game2048;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.example.Hangman.Hangman;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
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
                Hangman hangman = new Hangman();
                hangman.start();
                break;
            case 4:
                System.out.println("2048 Game");
                Game2048 game2048 = new Game2048();
                game2048.startGame();
                break;
        }
//        HibernateFactory hibernateFactory = new HibernateFactory();
//        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        session.close();
//        sessionFactory.close();
    }
}
