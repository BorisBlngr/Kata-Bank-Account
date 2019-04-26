package fr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        newHistoric(DEPOSIT, money);
    }

    void withdrawal(Money money) {
        this.money = this.money.minus(money);
        newHistoric(WITHDRAWAL, money);
    }

    void withdrawalFull() {
        withdrawal(this.money);
    }

    private void newHistoric(OPERATION operation, Money amount) {
        historic.add(new AccountOperation(operation, LocalDateTime.now(), amount, this.money));
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

        return Objects.equals(money, account.money);

    }

    @Override
    public int hashCode() {
        return money != null ? money.hashCode() : 0;
    }
}
