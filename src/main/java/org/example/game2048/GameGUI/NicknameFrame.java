package org.example.game2048.GameGUI;

import org.example.game2048.Factory;
import org.example.game2048.GameGUI.GameFrame;
import org.example.game2048.GameGUI.MenuFrame;
import org.example.game2048.board.Board;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.user.User;
import org.example.game2048.user.UserProcessor;
import org.hibernate.SessionFactory;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class NicknameFrame extends JFrame {
    private final JFrame nicknameFrame = new JFrame();
    private JButton submitButton;
    private JTextField nicknameField;
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final UserProcessor userProcessor = new UserProcessor();
    private final SessionFactory sessionFactory = new Factory().getSessionFactory();

    public NicknameFrame() {
        nicknameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nicknameFrame.setLayout(new FlowLayout());
        nicknameFrame.setTitle("2048 Game");

        setNicknameField();
        setSubmitButton();

        nicknameFrame.add(nicknameField);
        nicknameFrame.add(submitButton);
        nicknameFrame.setSize(250, 120);
        nicknameFrame.setVisible(true);
    }

    private void setNicknameField() {
        nicknameField = new JTextField();
        nicknameField.setPreferredSize(new Dimension(150, 35));
        nicknameField.setFont(new Font("Consolas", Font.ITALIC, 30));
        nicknameField.setForeground(new Color(0xFFA200));
        nicknameField.setBackground(Color.black);
        nicknameField.setCaretColor(new Color(0xFFA200));
        nicknameField.setText("nickname");
    }

    private void setSubmitButton() {
        submitButton = new JButton("submit");
        submitButton.setFont(new Font("Consolas", Font.ITALIC, 15));
        submitButton.setFocusable(false);
        submitButton.addActionListener(e -> {
            nicknameFrame.dispose();
            User user = userProcessor.getUser(nicknameField.getText(), sessionFactory);
            List<Board> userBoardList = boardProcessor.getUserBoardList(user.getId(),sessionFactory);
            if (userBoardList.size() > 1){
                new MenuFrame(user, sessionFactory);
            }else {
                new GameFrame(user, sessionFactory);
            }

        });
    }

}
