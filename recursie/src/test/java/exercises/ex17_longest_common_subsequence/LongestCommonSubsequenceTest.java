package exercises.ex17_longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static exercises.ex17_longest_common_subsequence.LongestCommonSubsequence.longestCommonSubsequences;
import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonSubsequenceTest {

    @Test
    public void example1() {
        assertThat(longestCommonSubsequences("gitaarsnaar", "imaginair"))
                .isIn("ginar", "ianar");

    }

    @Test
    public void example2() {
        assertThat(longestCommonSubsequences("aardappel", "adoptie"))
                .isEqualTo("adpe");

    }

    @Test
    public void first_is_empty() {
        assertThat(longestCommonSubsequences("", "hello"))
                .isEqualTo("");
    }

    @Test
    public void second_is_empty() {
        assertThat(longestCommonSubsequences("hello", ""))
                .isEqualTo("");
    }

    @Test
    public void both_same() {
        assertThat(longestCommonSubsequences("hello", "hello"))
                .isEqualTo("hello");
    }


}
