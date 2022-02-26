package org.example.Game2048;

import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class Game2048 {
    public static void main(String[] args) {

        Session session = new HibernateFactory().getSessionFactory().openSession();
        UserProcessor userProcessor = new UserProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze '2048'!\n" +
                "Podaj swój nickname:");

        String userNickname = scanner.nextLine();
        User user = new UserProcessor().getUser(userNickname, session);

        System.out.println("Wybierz co chcesz zrobić: \n" +
                "1 - nowa gra \n" +
                "2 - wczytaj grę");
        switch (scanner.nextInt()){
            case 1:
                userProcessor.addNewBoard(user,session);
                BoardGenerator.printBoard(user.getBoardList().get(0).getPointList());
                session.close();
                break;
            case 2:
                System.out.println("Wczytano ostatnią grę!");
                List<Board> boardList = user.getBoardList();
                int index = boardList.size()-1;
                BoardGenerator.printBoard(boardList.get(index).getPointList());
                break;
        }

    }
}
