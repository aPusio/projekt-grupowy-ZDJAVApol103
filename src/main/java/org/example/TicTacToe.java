//package org.example;
//
//import org.example.Service.Paair;
//import org.example.Service.SaveTheGame;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.time.LocalDateTime;
//import java.util.*;
//
//public class TicTacToe {
//    public static void main(String[] args) {
//
//        List<Paair> listPaair = new ArrayList<>();
//        List<Integer> listNumbers = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//
//        HibernateFactory hibernateFactory = new HibernateFactory();
//        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
//        Session session = sessionFactory.openSession();
//
//
//
//
//
//        String pl, pl1, pl2, turn;
//        int fieldNumber;
//        do {
//            Comment.PlayerChoice();
//            pl = scanner.next();
//        } while ((!Objects.equals(pl, "x")) && (!Objects.equals(pl, "o")));
//        do {
//            Comment.ThePlayerStartsTheGame();
//            pl1 = scanner.next();
//        } while ((!Objects.equals(pl1, "x")) && (!Objects.equals(pl1, "o")));
//        do {
//            if (Objects.equals(pl1, "x")) {
//                pl2 = "o";
//            } else pl2 = "x";
//            PlayerOne player = new PlayerOne(pl1);
//            do {
//                if (Objects.equals(pl1, pl)) {
//                    Comment.FieldSelection();
//                    fieldNumber = scanner.nextInt();
//                } else {
//                    Random random = new Random();
//                    fieldNumber = random.nextInt(9) + 1;
//                }
//            }
//            while ((Methods.CheckedLists(fieldNumber, listNumbers)) && fieldNumber < 10 && fieldNumber > 0);
//            String[][] board = new String[3][3];
//
//            for (int i = 0; i < board.length; i++) {
//                for (int j = 0; j < board.length; j++) {
//                    board[i][j] = " ";
//                }
//            }
//            for (Paair o : listPaair) {
//                Methods.MapState(o, board);
//            }
//            Methods.State(fieldNumber, String.valueOf(player), board);
//            listNumbers.add(fieldNumber);
//            listPaair.add(new Paair(String.valueOf(player), fieldNumber));
//            Comment.GameBoard(board);
//            System.out.println(listNumbers);
//            do {
//                Comment.FurtherMove();
//                turn = scanner.next();
//            } while ((!Objects.equals(turn, "n")) && (!Objects.equals(turn, "e")));
//            if ((Objects.equals(turn, "n")) && Objects.equals(String.valueOf(player), pl1)) {
//                pl1 = pl2;
//            }
//            if (Methods.EndGame(listPaair)) {
//                break;
//            }
//        } while (!Objects.equals(turn, "e"));
//        scanner.close();
//        Comment.WinPlayer(listPaair);
////        HibernateFactory hibernateFactory = new HibernateFactory();
////        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
////        Session session = sessionFactory.openSession();
//
//        SaveTheGame saveTheGame = new SaveTheGame();
//        saveTheGame.setLocalDateTime(LocalDateTime.now());
//        saveTheGame.setListPaair(listPaair);
//        session.save(saveTheGame);
//        for (Paair paair : listPaair) {
//            paair.setSaveTheGame(saveTheGame);
//            session.save(paair);
//        }
//        session.close();
//        sessionFactory.close();
//    }
//    public static void load(SessionFactory sessionFactory,Long ID){
//        Session session1 = sessionFactory.openSession();
//        List<Paair> from_paair = session1.createQuery("FROM Paair", Paair.class).getResultList();
////        Query<Paair> query = session1.createQuery("FROM Paair WHERE Paair.ID = :ID", Paair.class);
////        query.setParameter("ID",ID);
////        List<Paair> paairList = query.getResultList();
////        session1.close();
//    }
//}