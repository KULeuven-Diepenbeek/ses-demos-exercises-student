package be.kuleuven;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;

public class Scorebord {

    public static void main(String[] args) throws FileNotFoundException {
        Scorebord sb = new Scorebord();
        sb.voegToe("Arne", 5);
        for (Speler s : sb.scorebord){
            System.out.println(s.getNaam());
        }
        sb.save();
    }
    public static final String FILENAME = "./scorebord.json";
    private ArrayList<Speler> scorebord;
    public Scorebord() throws FileNotFoundException {
        this.scorebord = new ArrayList<Speler>();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(FILENAME));
            JsonArray data = gson.fromJson(reader, JsonArray.class);
            for (JsonElement jo : data){
                Speler s = gson.fromJson(jo, Speler.class);
                this.scorebord.add(s);
            }

        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(NullPointerException npe){
            npe.printStackTrace();
        }
    }
    public ArrayList<Speler> getScorebord(){
        return this.scorebord;
    }
    public void save(){
        try (Writer writer = new FileWriter(FILENAME)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(this.scorebord, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param x naam van de speler
     * @param huidigeScore de code
     */
    public void voegToe(String x, int huidigeScore) {
        Speler s = new Speler(x,huidigeScore);
        scorebord.add(s);
    }
    public int getTotaleScore(String x) {
        int totaleScore = 0;
        for (Speler s : this.scorebord){
            if (s.getNaam().equals(x)){
                totaleScore += s.getScore();
            }
        }
        return totaleScore;
    }
    public String getWinnaar() {
        ArrayList<String> verschillendeSpelers = new ArrayList<String>();
        for (Speler s : scorebord){
            if (!verschillendeSpelers.contains(s.getNaam())){
                verschillendeSpelers.add(s.getNaam());
            }
        }

        String winnaar = "No one";
        int highScore = 0;
        for (Speler s : scorebord){
            if (getTotaleScore(s.getNaam())>highScore){
                winnaar = s.getNaam();
                highScore = getTotaleScore(s.getNaam());
            }
        }
        return winnaar;
    }
}

