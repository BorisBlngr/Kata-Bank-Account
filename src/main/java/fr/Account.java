package fr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static fr.OPERATION.DEPOSIT;
import static fr.OPERATION.WITHDRAWAL;

public class Account {
    private Money money;
    private List<AccountOperation> historic = new ArrayList<>();

    Account(Money money) {
        this.money = money;
    }

    void deposit(Money money) {
        this.money = money.add(this.money);
        historic.add(new AccountOperation(DEPOSIT, LocalDateTime.now(), money, this.money));
    }

    void withdrawal(Money money) {
        this.money = this.money.minus(money);
        historic.add(new AccountOperation(WITHDRAWAL, LocalDateTime.now(), money, this.money));
    }

    void withdrawalFull() {
        this.money = Money.of(0);
    }

    List<AccountOperation> getHistoric() {
        return historic;
    }

    @Override
    public String toString() {
        return "fr.Account{" +
                "money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return money != null ? money.equals(account.money) : account.money == null;

    }

    @Override
    public int hashCode() {
        return money != null ? money.hashCode() : 0;
    }
}
