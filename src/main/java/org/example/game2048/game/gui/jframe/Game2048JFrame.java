package org.example.game2048.game.gui.jframe;

import org.example.game2048.game.gui.Game2048;

public class Game2048JFrame implements Game2048 {
    @Override
    public void start() {
        new NicknameFrame();
    }
}
