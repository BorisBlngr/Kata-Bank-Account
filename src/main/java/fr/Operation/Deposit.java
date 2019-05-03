package fr.Operation;

import fr.Money;

public class Deposit implements Operation {
    @Override
    public Money operate(Money money, Money amount) {
        return money.add(amount);
    }

    @Override
    public String symbol() {
        return "+";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Deposit;
    }
}
