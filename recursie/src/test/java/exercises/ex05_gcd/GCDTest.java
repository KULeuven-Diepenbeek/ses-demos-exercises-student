package exercises.ex05_gcd;

import org.junit.jupiter.api.Test;

import static exercises.ex05_gcd.GCD.gcd;
import static org.assertj.core.api.Assertions.assertThat;

public class GCDTest {

    @Test
    public void gcd_test() {
        assertThat(gcd(21, 14)).isEqualTo(7);
    }

    @Test
    public void gcd_reversed() {
        assertThat(gcd(14, 21)).isEqualTo(7);
    }

    @Test
    public void gcd_one() {
        assertThat(gcd(21, 1)).isEqualTo(1);
    }

    @Test
    public void gcd_zero() {
        assertThat(gcd(21, 0)).isEqualTo(21);
    }

    @Test
    public void gcd_equal() {
        assertThat(gcd(21, 21)).isEqualTo(21);
    }
}
