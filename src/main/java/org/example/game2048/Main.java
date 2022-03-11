package org.example.game2048;

import org.example.game2048.game.gui.gamecmd.Game2048Cmd;
import org.example.game2048.game.gui.jframe.Game2048JFrame;

public class Main {
    public static void main(String[] args) {
//        CMD GUI
//        Game2048Cmd game2048Cmd = new Game2048Cmd();
//        game2048Cmd.start();
//        JFrame GUI
        Game2048JFrame game2048JFrame = new Game2048JFrame();
        game2048JFrame.start();
    }
}