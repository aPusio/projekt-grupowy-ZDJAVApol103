package org.example.game2048.game.gui.gamecmd;

import org.example.game2048.Factory;
import org.example.game2048.board.Board;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.game.gui.Game2048;
import org.example.game2048.movements.Movement;
import org.example.game2048.point.Point;
import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.example.game2048.user.UserProcessor;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game2048Cmd implements Game2048 {
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final UserProcessor userProcessor = new UserProcessor();
    private final PointProcessor pointProcessor = new PointProcessor();
    private final SessionFactory sessionFactory;

    public Game2048Cmd(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private void play(User user) {
        String move;
        do {
            List<Board> boardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
            if (boardList.size() > 3) {
                boardProcessor.deleteBoard(boardList.get(0).getId(), sessionFactory);
                boardList.remove(0);
            }
            int index = boardList.size() - 1;
            Board board = boardList.get(index);
            List<Point> points = new ArrayList<>(pointProcessor.getBoardPointList(board.getId(), sessionFactory));
            BoardGenerator.printBoard(points);
            System.out.println("Enter movements:\t" +
                    "W - Move up.\t" +
                    "S - Move down.\t" +
                    "D - Move right.\t" +
                    "A - Move left\t" +
                    "R - undo move\t" +
                    "Q - Quit.");
            move = new Scanner(System.in).nextLine();
            switch (move) {
                case "w":
                    board.setPointList(Movement.moveUp(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case "s":
                    board.setPointList(Movement.moveDown(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case "d":
                    board.setPointList(Movement.moveRight(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case "a":
                    board.setPointList(Movement.moveLeft(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case "r":
                    if (boardList.size() > 1) {
                        boardProcessor.deleteBoard(board.getId(), sessionFactory);
                        System.out.println("Undo last move!");
                    } else {
                        System.out.println("There is no more move to undo!");
                    }
                    break;
                case "q":
                    System.out.println("End!");
                    break;
                default:
                    System.out.println("Bad move!");
                    break;
            }
        } while (!move.equals("q"));

    }

    private void addBoard(User user, Board updatedBoard) {
        boardProcessor.addNewBoard(user, updatedBoard, sessionFactory);
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game '2048'!\n" +
                "Enter your nickname:");

        String userNickname = scanner.nextLine();
        User user = userProcessor.getUser(userNickname, sessionFactory);
        List<Board> userBoardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
        if (userBoardList.size() > 1) {
            System.out.println("Menu: \n" +
                    "1 - new game \n" +
                    "2 - load game");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Start new game!");
                    boardProcessor.getUserBoardList(user.getId(), sessionFactory)
                            .forEach(board -> boardProcessor.deleteBoard(board.getId(), sessionFactory));
                    boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
                    play(user);
                    break;
                case 2:
                    System.out.println("Loaded last game!");
                    play(user);
                    break;
            }
        } else {
            play(user);
        }
    }
}