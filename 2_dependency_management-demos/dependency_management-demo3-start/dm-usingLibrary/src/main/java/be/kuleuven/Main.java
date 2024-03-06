package be.kuleuven;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Breuk b = new Breuk(2,4);

        System.out.printf("Teller = "+b.getTeller());
        System.out.printf("Noemer = "+b.getNoemer());
    }
}