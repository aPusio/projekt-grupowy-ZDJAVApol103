package org.example.game2048.GameGUI;

import org.example.game2048.GameGUI.GameFrame;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.user.User;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final JFrame menuFrame = new JFrame();
    private JButton newGameButton;
    private JButton loadGameButton;
    private final User user;
    private final SessionFactory sessionFactory;

    MenuFrame(User user, SessionFactory sessionFactory) {
        this.user = user;
        this.sessionFactory = sessionFactory;
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new GridLayout(2,1));
        menuFrame.setTitle("2048 Game");

        setNewGameButton();
        setLoadGameButton();

        menuFrame.add(newGameButton);
        menuFrame.add(loadGameButton);
        menuFrame.setSize(250, 120);
        menuFrame.setVisible(true);
    }

    private void setNewGameButton() {
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Consolas", Font.ITALIC, 15));
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(e -> {
            menuFrame.dispose();
            boardProcessor.getUserBoardList(user.getId(), sessionFactory)
                    .forEach(board -> boardProcessor.deleteBoard(board.getId(), sessionFactory));
            boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
            new GameFrame(user,sessionFactory);
        });
    }

    private void setLoadGameButton() {
        loadGameButton = new JButton("New Game");
        loadGameButton.setFont(new Font("Consolas", Font.ITALIC, 15));
        loadGameButton.setFocusable(false);
        loadGameButton.addActionListener(e -> {
            menuFrame.dispose();
            new GameFrame(user,sessionFactory);
        });
    }
}
