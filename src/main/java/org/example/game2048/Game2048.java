package org.example.game2048;

import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class Game2048 {
    private static final Session SESSION = new Factory().getSessionFactory().openSession();
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
            System.out.println("Podaj ruch\n" +
                    "1 - góra\n" +
                    "2 - dół\n" +
                    "3 - prawo\n" +
                    "4 - lewo");
            move = new Scanner(System.in).nextInt();
            switch (move) {
                case 1:
                    board.setPointList(Movement.moveUp(board.getPointList()));
                    USER_PROCESSOR.addNewBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 2:
                    board.setPointList(Movement.moveDown(board.getPointList()));
                    USER_PROCESSOR.addNewBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 3:
                    board.setPointList(Movement.moveRight(board.getPointList()));
                    USER_PROCESSOR.addNewBoard(user, BoardGenerator.updateBoard(board));
                    break;
                case 4:
                    board.setPointList(Movement.moveLeft(board.getPointList()));
                    USER_PROCESSOR.addNewBoard(user, BoardGenerator.updateBoard(board));
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

    public static void main(String[] args) {
        Game2048 game2048 = new Game2048();
        game2048.startGame();

    }
}