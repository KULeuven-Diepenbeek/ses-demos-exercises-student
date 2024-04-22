package examples.hanoi;

public class Hanoi {

    private static void hanoi(int n, String from, String to, String helper) {
        if (n <= 0) return;
        hanoi(n - 1, from, helper, to);
        System.out.println("Verplaats de bovenste schijf van stapel " + from + " naar stapel " + to);
        hanoi(n - 1, helper, to, from);
    }
    public static void main(String[] args) {
        hanoi(4, "A", "C", "B");
    }
}
