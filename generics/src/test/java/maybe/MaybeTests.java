package maybe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaybeTests {

    @Test
    public void maybeWithValue() {
        Maybe<String> maybe = Maybe.some("Yes");
        assertThat(maybe.hasValue()).isTrue();
        assertThat(maybe.getValue()).isEqualTo("Yes");
    }

    @Test
    public void maybeWithoutValue() {
        Maybe<String> maybe = Maybe.none();
        assertThat(maybe.hasValue()).isFalse();
        assertThat(maybe.getValue()).isNull();
    }

    @Test
    public void maybeMapWithValue() {
        Maybe<String> maybe = Maybe.some("Hello");
        Maybe<Integer> result = maybe.map((str) -> str.length());
        assertThat(result.hasValue()).isTrue();
        assertThat(result.getValue()).isEqualTo(5);
    }

    @Test
    public void maybeMapWithValue2() {
        Maybe<String> maybe = Maybe.some("Hello");
        Maybe<String> result = maybe.map((str) -> str + "!");
        assertThat(result.hasValue()).isTrue();
        assertThat(result.getValue()).isEqualTo("Hello!");
    }

    @Test
    public void maybeMapWithoutValue() {
        Maybe<String> maybe = Maybe.none();
        Maybe<Integer> result = maybe.map((str) -> str.length());
        assertThat(result.hasValue()).isFalse();
    }

}
