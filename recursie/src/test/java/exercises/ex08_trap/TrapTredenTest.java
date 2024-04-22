package exercises.ex08_trap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrapTredenTest {

    @Test
    public void test_0() {
        assertThat(TrapTreden.trapTreden(0)).isEqualTo(1);
    }

    @Test
    public void test_1() {
        assertThat(TrapTreden.trapTreden(1)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        assertThat(TrapTreden.trapTreden(2)).isEqualTo(2);
    }

    @Test
    public void test_4() {
        assertThat(TrapTreden.trapTreden(4)).isEqualTo(5);
    }

    @Test
    public void test_10() {
        assertThat(TrapTreden.trapTreden(10)).isEqualTo(89);
    }
}
