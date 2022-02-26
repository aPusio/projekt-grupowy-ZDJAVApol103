package org.example.Game2048;

import org.example.Game2048.Board.Board;
import org.example.Game2048.Board.BoardGenerator;
import org.example.Game2048.User.User;
import org.example.Game2048.User.UserProcessor;
import org.example.HibernateFactory;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class Game2048 {
    public void startGame(){
        Session session = new HibernateFactory().getSessionFactory().openSession();
        UserProcessor userProcessor = new UserProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze '2048'!\n" +
                "Podaj swój nickname:");

        String userNickname = scanner.nextLine();
        User user = new UserProcessor().getUser(userNickname, session);
        if (user.getBoardList().size()>1){
            System.out.println("Wybierz co chcesz zrobić: \n" +
                    "1 - nowa gra \n" +
                    "2 - wczytaj grę");
            switch (scanner.nextInt()){
                case 1:
                    userProcessor.addNewBoard(user,session);
                    BoardGenerator.printBoard(user.getBoardList().get(0).getPointList());
                    break;
                case 2:
                    System.out.println("Wczytano ostatnią grę!");
                    List<Board> boardList = user.getBoardList();
                    int index = boardList.size()-1;
                    BoardGenerator.printBoard(boardList.get(index).getPointList());
                    break;
            }
        }else {
            System.out.println("Nowa gra!");
            List<Board> boardList = user.getBoardList();
            BoardGenerator.printBoard(boardList.get(0).getPointList());
        }
        session.close();
    }
}
