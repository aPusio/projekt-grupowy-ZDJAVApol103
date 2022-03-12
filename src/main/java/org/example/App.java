package org.example;

import org.example.Hangman.Hangman;
import org.example.game2048.Main;
import org.example.game2048.game.gui.gamecmd.Game2048Cmd;
import org.example.game2048.game.gui.jframe.Game2048JFrame;

import java.util.Scanner;

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
//                CMD GUI
//                Game2048Cmd game2048Cmd = new Game2048Cmd(new HibernateFactory().getSessionFactory());
//                game2048Cmd.start();
//                JFrame GUI
                Game2048JFrame game2048JFrame = new Game2048JFrame(new HibernateFactory().getSessionFactory());
                game2048JFrame.start();
                break;
        }
    }
}
