package fr;

import org.junit.Test;

public class MoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void money_can_not_be_negative() {
        Money.of(-10);
    }

}