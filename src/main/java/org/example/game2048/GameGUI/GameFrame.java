package org.example.game2048.GameGUI;

import org.example.game2048.Movement;
import org.example.game2048.board.Board;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.point.Point;
import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.example.game2048.user.UserProcessor;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {
    private final JPanel jPanel;
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final UserProcessor userProcessor = new UserProcessor();
    private final PointProcessor pointProcessor = new PointProcessor();
    private final User user;
    private final SessionFactory sessionFactory;
    private final List<JTextField> boxList = new ArrayList<>();
    private List<Point> points;
    private Board board;


    GameFrame(User user, SessionFactory sessionFactory) {
        this.user = user;
        this.sessionFactory = sessionFactory;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 4));
        jPanel.setBounds(0, 0, 410, 395);

        setBoxes();
        play();
        movement(jPanel);



        frame.add(jPanel);

        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void setBoxes() {
        for (int i = 0; i < 16; i++) {
            boxList.add(new JTextField());
        }
        for (JTextField box : boxList) {
            box.setEditable(false);
            box.setFont(new Font("Consolas", Font.BOLD, 60));
            box.setHorizontalAlignment(JTextField.CENTER);
            box.setForeground(new Color(0xFFA200));
            jPanel.add(box);
        }
    }

    private void movement(JPanel box) {
        Action downAction = new DownAction();
        Action rightAction = new RightAction();
        Action leftAction = new LeftAction();
        Action upAction = new UpAction();

        box.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        box.getActionMap().put("upAction", upAction);
        box.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        box.getActionMap().put("rightAction", rightAction);
        box.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        box.getActionMap().put("leftAction", leftAction);
        box.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        box.getActionMap().put("downAction", downAction);
    }

    private void addBoard(User user, Board updatedBoard) {
        boardProcessor.addNewBoard(user, updatedBoard, sessionFactory);
    }

    private void drawBoard(List<Point> pointList) {
        boolean isFilled;
        int boxIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                isFilled = false;
                for (Point point : pointList) {
                    if (point.getX() == j && point.getY() == i) {
                        boxList.get(boxIndex).setText(String.valueOf(point.getValue()));
                        isFilled = true;
                    }
                }
                if (!isFilled) {
                    boxList.get(boxIndex).setText("");
                }
                boxIndex++;
            }
        }
    }

    private void play() {
        List<Board> boardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
        if (boardList.size() > 3) {
            boardProcessor.deleteBoard(boardList.get(0).getId(), sessionFactory);
            boardList.remove(0);
        }
        int indexOfLastBoard = boardList.size() - 1;
        board = boardList.get(indexOfLastBoard);
        points = new ArrayList<>(pointProcessor.getBoardPointList(board.getId(), sessionFactory));
        drawBoard(points);
    }

    public class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveUp(points));
            addBoard(user, BoardGenerator.updateBoard(board));
            play();
        }
    }

    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveLeft(points));
            addBoard(user, BoardGenerator.updateBoard(board));
            play();
        }
    }

    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveDown(points));
            addBoard(user, BoardGenerator.updateBoard(board));
            play();
        }
    }

    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveRight(points));
            addBoard(user, BoardGenerator.updateBoard(board));
            play();
        }
    }
}

