package fr.Operation;

import fr.Money;

public interface Operation {
    Money operate(Money money, Money amount);

    String symbol();
}
