package org.example.game2048.game.gui.jframe;

import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.user.User;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final JFrame menuFrame = new JFrame();
    private final ImageIcon icon = new ImageIcon(
            "src\\main\\resources\\2048_logo.png");
    private JButton newGameButton;
    private JButton loadGameButton;
    private JLabel menuLabel;
    private JLabel iconLabel;
    private final User user;
    private final SessionFactory sessionFactory;

    MenuFrame(User user, SessionFactory sessionFactory) {
        this.user = user;
        this.sessionFactory = sessionFactory;

        setNewGameButton();
        setLoadGameButton();
        setMenuLabel();
        setIconLabel();
        setMenuFrame();
    }

    private void setMenuFrame() {
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);
        menuFrame.setTitle("Game2048");
        menuFrame.setIconImage(icon.getImage());
        menuFrame.add(menuLabel);
        menuFrame.add(iconLabel);
        menuFrame.getContentPane().setBackground(new Color(0xFFA200));
        menuFrame.setSize(250, 350);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }

    private void setMenuLabel() {
        menuLabel = new JLabel();
        menuLabel.setLayout(new GridLayout(2, 1));
        menuLabel.setBounds(20, 10, 200, 120);
        menuLabel.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 5));
        menuLabel.add(newGameButton);
        menuLabel.add(loadGameButton);
    }

    private void setIconLabel() {
        iconLabel = new JLabel();
        iconLabel.setBounds(20, 140, 200, 160);
        iconLabel.setIcon(new ImageIcon(
                icon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), Image.SCALE_DEFAULT)
        ));
    }

    private void setNewGameButton() {
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Consolas", Font.ITALIC, 25));
        newGameButton.setBackground(new Color(0xCFEFD794));
        newGameButton.setFocusable(false);
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        newGameButton.addActionListener(e -> {
            menuFrame.dispose();
            boardProcessor.getUserBoardList(user.getId(), sessionFactory)
                    .forEach(board -> boardProcessor.deleteBoard(board.getId(), sessionFactory));
            boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
            new GameFrame(user, sessionFactory);
        });
    }

    private void setLoadGameButton() {
        loadGameButton = new JButton("Load Game");
        loadGameButton.setFont(new Font("Consolas", Font.ITALIC, 25));
        loadGameButton.setBackground(new Color(0xCFEFD794));
        loadGameButton.setFocusable(false);
        loadGameButton.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        loadGameButton.addActionListener(e -> {
            menuFrame.dispose();
            new GameFrame(user, sessionFactory);
        });
    }
}
