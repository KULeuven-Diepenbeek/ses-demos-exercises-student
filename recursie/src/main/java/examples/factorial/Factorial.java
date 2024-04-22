package examples.factorial;

public class Factorial {

    static int fac(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative");
        if (n == 0) {
            return 1;
        }
        return n * fac(n-1);
    }
}
