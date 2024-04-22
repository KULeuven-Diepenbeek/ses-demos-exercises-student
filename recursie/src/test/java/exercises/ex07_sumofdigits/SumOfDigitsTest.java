package exercises.ex07_sumofdigits;

import org.junit.jupiter.api.Test;

import static exercises.ex07_sumofdigits.SumOfDigits.sumOfDigits;
import static org.assertj.core.api.Assertions.assertThat;

public class SumOfDigitsTest {

    @Test
    void sum_of_zero_is_zero() {
        assertThat(sumOfDigits(0)).isEqualTo(0);
    }

    @Test
    void sum_of_digit_with_single_digit() {
        assertThat(sumOfDigits(8)).isEqualTo(8);
    }

    @Test
    void sum_of_digit_with_two_digits_single_reduction() {
        assertThat(sumOfDigits(34)).isEqualTo(7);
    }

    @Test
    void sum_of_digit_with_multiple_digits_single_reduction() {
        assertThat(sumOfDigits(112311)).isEqualTo(9);
    }

    @Test
    void sum_of_digit_with_multiple_reductions() {
        assertThat(sumOfDigits(62984)).isEqualTo(2);
    }

    @Test
    void sum_of_digit_with_multiple_reductions_all_ones() {
        assertThat(sumOfDigits(111111111111L)).isEqualTo(3);
    }

}
