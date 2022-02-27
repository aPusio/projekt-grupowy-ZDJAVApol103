package org.example.Game2048;

public class EndOfGameException extends RuntimeException{
    public EndOfGameException() {
        super("There is no more move!");
    }
}
