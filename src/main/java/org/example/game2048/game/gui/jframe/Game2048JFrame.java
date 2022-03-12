package org.example.game2048.game.gui.jframe;

import org.example.game2048.game.gui.Game2048;
import org.hibernate.SessionFactory;

public class Game2048JFrame implements Game2048 {
    private final SessionFactory sessionFactory;

    public Game2048JFrame(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void start() {
        new NicknameFrame(sessionFactory);
    }
}
