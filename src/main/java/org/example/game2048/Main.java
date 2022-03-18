package org.example.game2048;

import org.example.game2048.game.gui.gamecmd.Game2048Cmd;
import org.example.game2048.game.gui.jframe.Game2048JFrame;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // own database
       SessionFactory sessionFactory = new Factory().getSessionFactory();
        // common group's database
//    Session session = new HibernateFactory().getSessionFactory();
//        CMD GUI
//        Game2048Cmd game2048Cmd = new Game2048Cmd(sessionFactory);
//        game2048Cmd.start();
//        JFrame GUI
        Game2048JFrame game2048JFrame = new Game2048JFrame(sessionFactory);
        game2048JFrame.start();
    }
}