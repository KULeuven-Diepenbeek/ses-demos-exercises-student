package exercises.ex01_palindrome;

import org.junit.jupiter.api.Test;

import static exercises.ex01_palindrome.Palindrome.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {
    @Test
    void empty_string_is_a_palindrome() {
        assertThat(isPalindrome("")).isTrue();
    }

    @Test
    void string_with_one_character_is_a_palindrome() {
        assertThat(isPalindrome("x")).isTrue();
    }

    @Test
    void string_with_different_first_and_last_character_is_not_a_palindrome() {
        assertThat(isPalindrome("xy")).isFalse();
    }

    @Test
    void true_palindrome_odd_length() {
        assertThat(isPalindrome("racecar")).isTrue();
    }

    @Test
    void true_palindrome_even_length() {
        assertThat(isPalindrome("redder")).isTrue();
    }

    @Test
    void palindrome_examples() {
        assertThat(isPalindrome("racecar")).isTrue();
        assertThat(isPalindrome("level")).isTrue();
        assertThat(isPalindrome("deified")).isTrue();
        assertThat(isPalindrome("lepel")).isTrue();
        assertThat(isPalindrome("droomoord")).isTrue();
        assertThat(isPalindrome("redder")).isTrue();
        assertThat(isPalindrome("meetsysteem")).isTrue();
        assertThat(isPalindrome("koortsmeetsysteemstrook")).isTrue();
    }


}
