package org.example.Hangman;

import lombok.Data;

import java.awt.image.PackedColorModel;

@Data
public class Player {


    private long id;
    private String name;
    private int score;
    private int chances;

    public void subtractChance(){
        this.chances -=1;
    }

    public void increseScore() {
        this.score +=1;
    }

    public int chancesReversed(){
       return this.chances -7;
    }

    public static class PlayerBuilder{

        private long id;
        private String name;
        private int score;
        private int chanses;

        public PlayerBuilder(String name){
            this.name = name;
        }

        public PlayerBuilder name(String name){
            this.name = name;
            return this;
        }

        public PlayerBuilder chances(int chanses){
            this.chanses = chanses;
            return this;
        }

        public PlayerBuilder score(int score){
            this.score = score;
            return this;
        }

        public Player build(){
            Player player = new Player();
            player.name = this.name;
            player.chances = this.chanses;
            player.score = this.score;
            return player;
        }


    }

}

