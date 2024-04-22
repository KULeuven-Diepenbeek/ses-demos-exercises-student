package examples.factorial;

import org.junit.jupiter.api.Test;

import static examples.factorial.FactorialWrapper.factorial;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FactorialWrapperTest {

    @Test
    void factorial_of_zero_is_one() {
        assertThat(factorial(0)).isEqualTo(1);
    }

    @Test
    void factorial_of_one_is_one() {
        assertThat(factorial(1)).isEqualTo(1);
    }

    @Test
    void factorial_of_five_is_120() {
        assertThat(factorial(5)).isEqualTo(120);
    }

    @Test
    void factorial_of_negative_throws() {
        assertThatIllegalArgumentException().isThrownBy(() -> factorial(-1));
    }

}
