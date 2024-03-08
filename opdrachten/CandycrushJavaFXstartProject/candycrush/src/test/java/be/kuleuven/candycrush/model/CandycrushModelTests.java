package be.kuleuven.candycrush.model;

import org.junit.jupiter.api.Test;

public class CandycrushModelTests {

    @Test
    public void gegeven_wanneer_dan(){
        CandycrushModel model = new CandycrushModel("Arne");
        String result = model.getSpeler();
        assert (result.equals("Arne"));
    }

    //TODO: Delete previous test and test your own code

}
