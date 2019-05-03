package fr;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void money_can_not_be_negative() {
        Money.of(-10);
    }

    @Test
    public void always_print_two_decimal_digits() {
        Assertions.assertThat(Money.of(25).toString()).isEqualTo("25,00");
    }
}