package be.kuleuven;

import java.util.ArrayList;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam, int score){
        this.naam = naam;
        this.score = score;
    }

    public String getNaam(){
        return naam;
    }
    public int getScore(){
        return score;
    }


}

