package exercises.ex06_power;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static exercises.ex06_power.Power.power;
import static org.assertj.core.api.Assertions.assertThat;

public class PowerTest {

    private static final Offset<Double> PRECISION = Offset.offset(0.00001);

    @Test
    public void powerZero() {
        assertThat(power(2.0, 0)).isCloseTo(1.0, PRECISION);
    }

    @Test
    public void powerOne() {
        assertThat(power(2.0, 1)).isCloseTo(2.0, PRECISION);
    }

    @Test
    public void powerPowOfTwo() {
        assertThat(power(2.0, 16)).isCloseTo(65536, PRECISION);
    }

    @Test
    public void powerPowOfTwoMinOne() {
        assertThat(power(2.0, 15)).isCloseTo(32768, PRECISION);
    }

    @Test
    public void powerMixed() {
        assertThat(power(2.0, 28)).isCloseTo(268435456, PRECISION);
    }


    @Test
    public void powerNegativeEven() {
        assertThat(power(2.0, -4)).isCloseTo(0.0625, PRECISION);
    }

    @Test
    public void powerNegativeOdd() {
        assertThat(power(2.0, -5)).isCloseTo(0.03125, PRECISION);
    }

}
