package exercises.ex09_gepast_betalen;

import exercises.ex08_trap.TrapTreden;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GepastBetalenTest {

    @Test
    public void test_no_coins() {
        assertThat(GepastBetalen.kanGepastBetalen(10, List.of())).isFalse();
    }

    @Test
    public void test_single_coins() {
        assertThat(GepastBetalen.kanGepastBetalen(10, List.of(10))).isTrue();
    }

    @Test
    public void test_all_coins() {
        assertThat(GepastBetalen.kanGepastBetalen(80, List.of(10, 20, 50))).isTrue();
    }

    @Test
    public void test_too_many_coins() {
        assertThat(GepastBetalen.kanGepastBetalen(20, List.of(50, 10, 10, 5))).isTrue();
    }

    @Test
    public void test_too_many_coins_2() {
        assertThat(GepastBetalen.kanGepastBetalen(125, List.of(100, 100, 50, 20, 10, 5))).isTrue();
    }

    @Test
    public void test_impossible() {
        assertThat(GepastBetalen.kanGepastBetalen(260, List.of(100, 100, 50, 20, 5))).isFalse();
    }

}
