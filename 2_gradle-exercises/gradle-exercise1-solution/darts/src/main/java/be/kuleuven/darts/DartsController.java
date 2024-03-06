package be.kuleuven.darts;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import be.kuleuven.Scorebord;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class DartsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle circleBig;

    @FXML
    private Circle circleMiddle;

    @FXML
    private Circle circleSmall;

    @FXML
    private TextField playerTextField;

    @FXML
    private Label winnerLbl;

    private Scorebord sb;
    @FXML
    void initialize() throws FileNotFoundException {
        assert circleBig != null : "fx:id=\"circleBig\" was not injected: check your FXML file 'darts-view.fxml'.";
        assert circleMiddle != null : "fx:id=\"circleMiddle\" was not injected: check your FXML file 'darts-view.fxml'.";
        assert circleSmall != null : "fx:id=\"circleSmall\" was not injected: check your FXML file 'darts-view.fxml'.";
        assert playerTextField != null : "fx:id=\"playerTextField\" was not injected: check your FXML file 'darts-view.fxml'.";
        assert winnerLbl != null : "fx:id=\"winnerLbl\" was not injected: check your FXML file 'darts-view.fxml'.";
        sb = new Scorebord();
        circleBig.setOnMouseClicked(event -> circleClicked(1));
        circleMiddle.setOnMouseClicked(event -> circleClicked(2));
        circleSmall.setOnMouseClicked(event -> circleClicked(3));
    }

    public void circleClicked(int score){
        String player = playerTextField.getText();
        if (player.equals("")){
            player = "Anonymous";
        }
        sb.voegToe(player,score);
        sb.save();
        winnerLbl.setText(sb.getWinnaar()+" met score "+sb.getTotaleScore(sb.getWinnaar()));
    }

}
