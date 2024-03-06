package be.kuleuven;

import java.io.FileNotFoundException;
import java.util.Random;

public class DartsGame {
    private String player;
    private Scorebord bord;

    public static void main(String[] args) throws FileNotFoundException {
        //EXAMPLE GAME
        DartsGame dg = new DartsGame();
        dg.throwDart();
        System.out.println(dg.getBord().getWinnaar());
        dg.setPlayer("player2");
        dg.throwDart();
        dg.throwDart();
        dg.throwDart();
        System.out.println(dg.getBord().getWinnaar());
        System.out.println("Score player1 = "+dg.getBord().getTotaleScore("player1"));
        System.out.println("Score player2 = "+dg.getBord().getTotaleScore("player2"));
        System.out.println("Scorebord = "+dg.getBord().getScorebord());
        dg.getBord().save();
    }

    public DartsGame() throws FileNotFoundException {
        this.player = "player1";
        bord = new Scorebord();
    }

    public String getPlayer() {
        return player;
    }

    public Scorebord getBord() {
        return bord;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void throwDart() {
        Random rn = new Random();
        int score = (int) (1+Math.random()*3);
        bord.voegToe(this.player,score);
    }
}
