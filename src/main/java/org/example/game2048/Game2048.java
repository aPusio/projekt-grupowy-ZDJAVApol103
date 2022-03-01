package org.example.game2048;

import org.example.game2048.board.Board;
import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.example.game2048.point.Point;
import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.example.game2048.user.UserProcessor;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game2048 {
    private final BoardProcessor boardProcessor = new BoardProcessor();
    private final UserProcessor userProcessor = new UserProcessor();
    private final PointProcessor pointProcessor = new PointProcessor();
//Prywatna DB:
    private final SessionFactory sessionFactory = new Factory().getSessionFactory();
//DB projektu wspólnego:
//    private  final Session session = new HibernateFactory().getSessionFactory();

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze '2048'!\n" +
                "Podaj swój nickname:");

        String userNickname = scanner.nextLine();
        User user = userProcessor.getUser(userNickname, sessionFactory);
        List<Board> userBoardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
        if (userBoardList.size() > 1) {
            System.out.println("Wybierz co chcesz zrobić: \n" +
                    "1 - nowa gra \n" +
                    "2 - wczytaj grę");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Rozpoczęto nową grę!");
                    boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
                    do {
                        play(user);
                    } while (new Scanner(System.in).nextInt() != 1);
                    break;
                case 2:
                    System.out.println("Wczytano ostatnią grę!");
                    do {
                        play(user);
                    } while (new Scanner(System.in).nextInt() != 1);
                    break;
            }
        } else {
            play(user);
        }
    }

    private void play(User user) {
        String move;
        do {
            List<Board> boardList = boardProcessor.getUserBoardList(user.getId(), sessionFactory);
            if (boardList.size() > 3) {
                boardProcessor.deleteBoard(boardList.get(0).getId(),sessionFactory);
                boardList.remove(0);
            }
            int index = boardList.size() - 1;
            Board board = boardList.get(index);
            List<Point> points = new ArrayList<>(pointProcessor.getBoardPointList(board.getId(), sessionFactory));
            BoardGenerator.printBoard(points);
            System.out.println("Enter movement:\n" +
                    "w - Move up.\n" +
                    "s - Move down.\n" +
                    "d - Move right.\n" +
                    "a - Move left\n" +
                    "q - Quit.");
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
                case "q":
                    System.out.println("Koniec!");
                    break;
                default:
                    System.out.println("Zły ruch!");
                    break;
            }
        } while (!move.equals("q"));

    }

    private void addBoard(User user, Board updatedBoard) {
        boardProcessor.addNewBoard(user, updatedBoard, sessionFactory);
    }

    public static void main(String[] args) {
        Game2048 game2048 = new Game2048();
        game2048.startGame();

    }
}