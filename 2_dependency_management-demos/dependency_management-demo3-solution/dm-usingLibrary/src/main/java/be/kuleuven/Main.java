package be.kuleuven;

// toevoegen !
import be.kuleuven.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Breuk b = new Breuk(2,4);

        System.out.println("Teller = "+b.getTeller());
        System.out.println("Noemer = "+b.getNoemer());
    }
}