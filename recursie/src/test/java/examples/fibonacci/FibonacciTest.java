package examples.fibonacci;

import org.junit.jupiter.api.Test;
import static examples.fibonacci.Fibonacci.fib;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FibonacciTest {

    @Test
    void fibonacci_zero() {
        assertThat(fib(0)).isEqualTo(0);
    }

    @Test
    void fibonacci_one() {
        assertThat(fib(1)).isEqualTo(1);
    }
    
    @Test
    void fibonacci_five() {
        assertThat(fib(5)).isEqualTo(5);
    }

    @Test
    void fibonacci_eight() {
        assertThat(fib(8)).isEqualTo(21);
    }

    @Test
    void fibonacci_of_negative_throws() {
        assertThatIllegalArgumentException().isThrownBy(() -> fib(-1));
    }

}
