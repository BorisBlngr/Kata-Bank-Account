package fr.Operation;

import fr.Money;

public class Withdrawal implements Operation {
    @Override
    public Money operate(Money money, Money amount) {
        return money.minus(amount);
    }

    @Override
    public String symbol() {
        return "-";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Withdrawal;
    }
}
