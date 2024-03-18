package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void when_creating_new_email_with_null_throws_exception() {
        Assertions.assertThatThrownBy(() -> new Email(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void when_creating_new_email_without_at_sign_throws_exception() {
        Assertions.assertThatThrownBy(() -> new Email("abc.com"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void when_creating_new_email_with_two_at_signs_throws_exception() {
        Assertions.assertThatThrownBy(() -> new Email("a@@bc.com"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void when_creating_new_email_not_ending_in_com_or_be_throws_exception() {
        Assertions.assertThatThrownBy(() -> new Email("a@bc.co"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
