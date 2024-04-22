package exercises.ex02_reverse_string;

import org.junit.jupiter.api.Test;

import static exercises.ex02_reverse_string.ReverseString.reverse;
import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {

    @Test
    public void reverse_empty_string() {
        assertThat(reverse("")).isEqualTo("");
    }

    @Test
    public void reverse_one_character() {
        assertThat(reverse("x")).isEqualTo("x");
    }

    @Test
    public void reverse_two_characters() {
        assertThat(reverse("xy")).isEqualTo("yx");
    }

    @Test
    public void reverse_many_characters() {
        assertThat(reverse("Hello")).isEqualTo("olleH");
    }

    @Test
    public void reverse_palindrome() {
        assertThat(reverse("racecar")).isEqualTo("racecar");
    }
}
