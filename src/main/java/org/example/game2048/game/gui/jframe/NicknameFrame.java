package org.example.game2048.game.gui.jframe;

import org.example.game2048.board.Board;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.user.User;
import org.example.game2048.user.UserProcessor;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NicknameFrame extends JFrame {
    private final JFrame nicknameFrame = new JFrame();
    private final ImageIcon icon = new ImageIcon("src\\main\\resources\\2048_logo.png");
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final UserProcessor userProcessor = new UserProcessor();
    private final SessionFactory sessionFactory;
    private JButton submitButton;
    private JTextField nicknameField;
    private JLabel nicknameLabel;
    private JLabel iconLabel;


    public NicknameFrame(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        setNicknameField();
        setSubmitButton();
        setNicknameLabel();
        setIconLabel();
        setNicknameFrame();
    }

    private void setNicknameFrame() {
        nicknameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nicknameFrame.setTitle("2048Game");
        nicknameFrame.setIconImage(icon.getImage());
        nicknameFrame.add(nicknameLabel);
        nicknameFrame.add(iconLabel);
        nicknameFrame.setLayout(null);
        nicknameFrame.setResizable(false);
        nicknameFrame.getContentPane().setBackground(new Color(0xFFA200));
        nicknameFrame.setSize(250, 350);
        nicknameFrame.setLocationRelativeTo(null);
        nicknameFrame.setVisible(true);
    }

    private void setNicknameLabel() {
        nicknameLabel = new JLabel();
        nicknameLabel.setLayout(new GridLayout(2, 1));
        nicknameLabel.setBounds(20, 10, 200, 120);
        nicknameLabel.add(nicknameField);
        nicknameLabel.add(submitButton);
        nicknameLabel.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 5));
    }

    private void setIconLabel() {
        iconLabel = new JLabel();
        iconLabel.setBounds(20, 140, 200, 160);
        iconLabel.setIcon(new ImageIcon(
                icon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), Image.SCALE_DEFAULT)
        ));
    }

    private void setNicknameField() {
        nicknameField = new JTextField();
        nicknameField.setPreferredSize(new Dimension(150, 35));
        nicknameField.setFont(new Font("Consolas", Font.ITALIC, 30));
        nicknameField.setForeground(new Color(0xCFEFD794, true));
        nicknameField.setBackground(Color.black);
        nicknameField.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        nicknameField.setCaretColor(new Color(0xFFA200));
        nicknameField.setHorizontalAlignment(JTextField.CENTER);
        nicknameField.setText("Nickname");
    }

    private void setSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Consolas", Font.ITALIC, 25));
        submitButton.setBackground(new Color(0xCFEFD794));
        submitButton.setFocusable(false);
        submitButton.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        submitButton.addActionListener(e -> {
            nicknameFrame.dispose();
            User user = userProcessor.getUser(nicknameField.getText(), sessionFactory);
            List<Board> userBoardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
            if (userBoardList.size() > 1) {
                new MenuFrame(user, sessionFactory);
            } else {
                new GameFrame(user, sessionFactory);
            }

        });
    }

}
