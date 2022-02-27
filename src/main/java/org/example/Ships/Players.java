package org.example.Ships;

public class Players {

    private Board board;
    private String name;
    private int score;

    public Players(Board board, String name, int score) {
        this.board = board;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Players(String name, Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Players{" +
                "board=" + board +
                ", name='" + name + '\'' +
                '}';
    }
}
