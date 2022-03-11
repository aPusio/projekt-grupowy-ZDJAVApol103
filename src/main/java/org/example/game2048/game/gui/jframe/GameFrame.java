package org.example.game2048.game.gui.jframe;

import org.example.game2048.board.Board;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.movements.Movement;
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
    private JButton newGameButton;
    private JButton backMoveButton;
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

        JPanel newGamePanel = new JPanel();
        newGamePanel.setLayout(new GridLayout(1, 2));
        newGamePanel.setBounds(0, 0, 406, 45);
        setNewGameButton();
        setBackMoveButton();
        newGamePanel.add(newGameButton);
        newGamePanel.add(backMoveButton);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(4, 4));
        gamePanel.setBounds(0, 45, 409, 388);

        setBoxes();
        updateBoardPoints();
        movement(gamePanel);

        JFrame gameFrame = new JFrame();
        gameFrame.add(gamePanel);
        gameFrame.add(newGamePanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(420, 470);
        gameFrame.setTitle("Game 2048 " + user.getNickname());
        gameFrame.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

    }
    private void setBackMoveButton(){
        backMoveButton = new JButton("Back Move");
        backMoveButton.setFont(new Font("Consolas", Font.ITALIC, 25));
        backMoveButton.setBackground(new Color(0xCFEFD794));
        backMoveButton.setFocusable(false);
        backMoveButton.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        backMoveButton.addActionListener(e -> {
            if (boardProcessor.getUserBoardList(user.getId(),sessionFactory).size() > 1) {
                boardProcessor.deleteBoard(board.getId(), sessionFactory);
                updateBoardPoints();
            } else {
                JOptionPane.showMessageDialog(null
                        , "There is no more move to back!"
                        , "No more back move"
                        , JOptionPane.PLAIN_MESSAGE);
            }
        });

    }

    private void setNewGameButton() {
        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Consolas", Font.ITALIC, 25));
        newGameButton.setBackground(new Color(0xCFEFD794));
        newGameButton.setFocusable(false);
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102), 2));
        newGameButton.addActionListener(e -> {
            boardProcessor.getUserBoardList(user.getId(), sessionFactory)
                    .forEach(board -> boardProcessor.deleteBoard(board.getId(), sessionFactory));
            boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
            updateBoardPoints();
        });
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
            box.setBorder(BorderFactory.createLineBorder(new Color(0x2D2102)));
            gamePanel.add(box);
        }
    }

    private void movement(JPanel boxesPanel) {
        Action downAction = new DownAction();
        Action rightAction = new RightAction();
        Action leftAction = new LeftAction();
        Action upAction = new UpAction();

        boxesPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        boxesPanel.getActionMap().put("upAction", upAction);
        boxesPanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        boxesPanel.getActionMap().put("rightAction", rightAction);
        boxesPanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        boxesPanel.getActionMap().put("leftAction", leftAction);
        boxesPanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        boxesPanel.getActionMap().put("downAction", downAction);
    }

    private void addBoard(User user) {
        Board updatedBoard = BoardGenerator.updateBoard(board);
        if (updatedBoard == null) {
            JOptionPane.showMessageDialog(null
                    , "This move is not allowed now!"
                    , "End of game move"
                    , JOptionPane.PLAIN_MESSAGE);
        } else {
            boardProcessor.addNewBoard(user, updatedBoard, sessionFactory);
            updateBoardPoints();
        }
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
            addBoard(user);
        }
    }

    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveLeft(boardPointsList));
            addBoard(user);
        }
    }

    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveDown(boardPointsList));
            addBoard(user);
        }
    }

    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            board.setPointList(Movement.moveRight(boardPointsList));
            addBoard(user);
        }
    }
}

