package examples.factorial;

public class FactorialWrapper {
    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        return factorial_worker(n, 1);
    }

    private static int factorial_worker(int n, int result) {
        if (n <= 0) return result;
        return factorial_worker(n-1, n * result);
    }
}
