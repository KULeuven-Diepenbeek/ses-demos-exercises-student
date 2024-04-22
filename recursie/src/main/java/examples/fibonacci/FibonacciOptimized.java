package examples.fibonacci;

import java.util.Arrays;

public class FibonacciOptimized {
    public static int fib(int n) {
        if (n < 0) throw new IllegalArgumentException();
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return fib_memoized(n, memo);
    }

    private static int fib_memoized(int n, int[] memo) {
        var result = memo[n];
        if (result == -1) {
            if (n == 0) result = 0;
            else if (n == 1) result = 1;
            else result = fib_memoized(n-1, memo) + fib_memoized(n-2, memo);
            memo[n] = result;
        }
        return result;
    }

    public static int fib2(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib_worker(n, 2, 0, 1); // n >= 2
    }
    private static int fib_worker(int targetN, int currentN, int prevprev, int prev) {
        if (currentN == targetN) return prevprev + prev;
        return fib_worker(targetN, currentN+1, prev, prevprev+prev);
    }

    public static void main(String[] args) {
        System.out.println(fib(20));
        System.out.println(fib2(20));
    }
}
