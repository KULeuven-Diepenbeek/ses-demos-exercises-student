package examples.factorial;

import org.junit.jupiter.api.Test;

import static examples.factorial.Factorial.fac;
import static org.assertj.core.api.Assertions.*;

public class FactorialTest {

    @Test
    void factorial_of_zero_is_one() {
        assertThat(fac(0)).isEqualTo(1);
    }

    @Test
    void factorial_of_one_is_one() {
        assertThat(fac(1)).isEqualTo(1);
    }

    @Test
    void factorial_of_five_is_120() {
        assertThat(FactorialWrapper.factorial(5)).isEqualTo(120);
    }

    @Test
    void factorial_of_negative_throws() {
        assertThatIllegalArgumentException().isThrownBy(() -> fac(-1));
    }

}
