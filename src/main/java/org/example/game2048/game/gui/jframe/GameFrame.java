package org.example.game2048.game.gui.jframe;

import org.example.game2048.movements.Movement;
import org.example.game2048.board.Board;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.point.Point;
import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {
    private final JPanel gamePanel;
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final PointProcessor pointProcessor = new PointProcessor();
    private final User user;
    private final SessionFactory sessionFactory;
    private final List<JTextField> boxList = new ArrayList<>();
    private List<Point> boardPointsList;
    private Board board;


    GameFrame(User user, SessionFactory sessionFactory) {
        this.user = user;
        this.sessionFactory = sessionFactory;

        JFrame gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(420, 420);
        gameFrame.setTitle("Game 2048");

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(4, 4));
        gamePanel.setBounds(0, 0, 409, 388);

        setBoxes();
        updateBoardPoints();
        movement(gamePanel);

        gameFrame.add(gamePanel);
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

    }

    private void setBoxes() {
        for (int i = 0; i < 16; i++) {
            boxList.add(new JTextField());
        }
        for (JTextField box : boxList) {
            box.setEditable(false);
            box.setFont(new Font("Consolas", Font.BOLD, 60));
            box.setHorizontalAlignment(JTextField.CENTER);
            box.setForeground(new Color(0x775100));
            box.setBackground(new Color(0xCFF6DFBC));
            box.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102),2));
            gamePanel.add(box);
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

    private void updateBoardPoints() {
        List<Board> boardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
        if (boardList.size() > 3) {
            boardProcessor.deleteBoard(boardList.get(0).getId(), sessionFactory);
            boardList.remove(0);
        }
        int indexOfLastBoard = boardList.size() - 1;
        board = boardList.get(indexOfLastBoard);
        boardPointsList = new ArrayList<>(pointProcessor.getBoardPointList(board.getId(), sessionFactory));
        drawBoard(boardPointsList);
    }


    public class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveUp(boardPointsList));
            addBoard(user, BoardGenerator.updateBoard(board));
            updateBoardPoints();
        }
    }

    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveLeft(boardPointsList));
            addBoard(user, BoardGenerator.updateBoard(board));
            updateBoardPoints();
        }
    }

    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveDown(boardPointsList));
            addBoard(user, BoardGenerator.updateBoard(board));
            updateBoardPoints();
        }
    }

    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveRight(boardPointsList));
            addBoard(user, BoardGenerator.updateBoard(board));
            updateBoardPoints();
        }
    }
}

