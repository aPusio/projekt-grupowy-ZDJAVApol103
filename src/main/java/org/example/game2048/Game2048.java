package org.example.game2048;

import org.example.HibernateFactory;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game2048 {
//    Prywatna DB:
//    private static final Session SESSION = new Factory().getSessionFactory().openSession();
//    DB projektu wspólnego:
    private static final Session SESSION = new HibernateFactory().getSessionFactory().openSession();
    private static final UserProcessor USER_PROCESSOR = new UserProcessor();

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze '2048'!\n" +
                "Podaj swój nickname:");

        String userNickname = scanner.nextLine();
        User user = new UserProcessor().getUser(userNickname, SESSION);
        if (user.getBoardList().size() > 1) {
            System.out.println("Wybierz co chcesz zrobić: \n" +
                    "1 - nowa gra \n" +
                    "2 - wczytaj grę");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Rozpoczęto nową grę!");
                    USER_PROCESSOR.addNewBoard(user, BoardGenerator.generateNewBoard());
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
        int move;
        do {
            List<Board> boardList = user.getBoardList();
            int index = boardList.size() - 1;
            BoardGenerator.printBoard(boardList.get(index).getPointList());
            Board board = boardList.get(index);
            List<Point> points = new ArrayList<>(board.getPointList());
            System.out.println("Podaj ruch\n" +
                    "1 - góra\n" +
                    "2 - dół\n" +
                    "3 - prawo\n" +
                    "4 - lewo");
            move = new Scanner(System.in).nextInt();
            switch (move) {
                case 1:
                    board.setPointList(Movement.moveUp(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 2:
                    board.setPointList(Movement.moveDown(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 3:
                    board.setPointList(Movement.moveRight(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 4:
                    board.setPointList(Movement.moveLeft(points));
                    addBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 0:
                    System.out.println("Koniec!");
                    break;
                default:
                    System.out.println("Zły ruch!");
                    break;
            }
        }while (move!=0);

    }

    private void addBoard(User user, Board updatedBoard) {
        USER_PROCESSOR.addNewBoard(user, updatedBoard);
    }

    public static void main(String[] args) {
        Game2048 game2048 = new Game2048();
        game2048.startGame();

    }
}