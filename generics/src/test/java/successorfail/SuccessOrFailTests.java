package successorfail;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuccessOrFailTests {
    @Test
    public void success() {
        SuccessOrFail<String, Exception> result = SuccessOrFail.success("This is the result");
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.successValue()).isEqualTo("This is the result");
    }

    @Test
    public void failure() {
        SuccessOrFail<String, Exception> result = SuccessOrFail.fail(new IllegalStateException());
        assertThat(result.isSuccess()).isFalse();
        assertThat(result.failValue()).isInstanceOf(IllegalStateException.class);
    }
}
