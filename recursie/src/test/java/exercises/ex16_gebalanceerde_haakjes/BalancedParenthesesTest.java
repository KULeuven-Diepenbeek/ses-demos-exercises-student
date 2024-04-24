package exercises.ex16_gebalanceerde_haakjes;

import org.junit.jupiter.api.Test;

import static exercises.ex16_gebalanceerde_haakjes.BalancedParentheses.isBalanced;
import static org.assertj.core.api.Assertions.assertThat;

public class BalancedParenthesesTest {

    @Test
    public void empty_string() {
        assertThat(isBalanced("")).isTrue();
    }

    @Test
    public void single_char() {
        assertThat(isBalanced("x")).isTrue();
    }

    @Test
    public void many_chars() {
        assertThat(isBalanced("aaa")).isTrue();
    }

    @Test
    public void single_open() {
        assertThat(isBalanced("(")).isFalse();
    }

    @Test
    public void single_closed() {
        assertThat(isBalanced(")")).isFalse();
    }

    @Test
    public void single_open_close() {
        assertThat(isBalanced("()")).isTrue();
    }

    @Test
    public void single_close_open() {
        assertThat(isBalanced(")(")).isFalse();
    }

    @Test
    public void double_open() {
        assertThat(isBalanced("((")).isFalse();
    }

    @Test
    public void double_closed() {
        assertThat(isBalanced("))")).isFalse();
    }

    @Test
    public void sequence() {
        assertThat(isBalanced("()()")).isTrue();
    }

    @Test
    public void nested() {
        assertThat(isBalanced("x(x(x(xax)x)(xb)x)x")).isTrue();
    }

    @Test
    public void missing_one() {
        assertThat(isBalanced("a(bc(def(xy))z")).isFalse();
    }

}
