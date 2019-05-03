package fr;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static fr.Operation.DEPOSIT;
import static fr.Operation.WITHDRAWAL;

public class Account {
    private Money money;
    private List<AccountOperation> accountOperations = new ArrayList<>();

    Account(Money money) {
        this.money = money;
    }

    void deposit(Money money) {
        this.money = this.money.add(money);
        newHistoric(DEPOSIT, money);
    }

    void withdrawal(Money money) {
        this.money = this.money.minus(money);
        newHistoric(WITHDRAWAL, money);
    }

    void withdrawalFull() {
        withdrawal(this.money);
    }

    private void newHistoric(Operation operation, Money amount) {
        accountOperations.add(new AccountOperation(operation, LocalDateTime.now(), amount, this.money));
    }

    List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    String printHistory() {
        StringBuilder history = new StringBuilder();
        accountOperations.forEach(accountOperation -> history.append(accountOperation.print()).append(" \n"));
        history.append("- - - - - - - \n");
        history.append(money.print());
        return history.toString();
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
