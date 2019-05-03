package fr;

import java.text.DecimalFormat;

class Money {
    private final int value;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    private Money(int value) {
        this.value = value;
    }

    static Money of(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("money can not be negative : " + value);
        }
        return new Money(value);
    }

    Money add(Money money) {
        return Money.of(this.value + money.value);
    }

    Money minus(Money money) {
        return Money.of(this.value - money.value);
    }

    String print() {
        return DECIMAL_FORMAT.format(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return value == money.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return print();
    }
}
