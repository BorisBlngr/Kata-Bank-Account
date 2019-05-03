package fr;

import fr.Operation.Deposit;
import fr.Operation.Operation;
import fr.Operation.Withdrawal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private Money money;
    private List<AccountOperation> accountOperations = new ArrayList<>();

    Account(Money money) {
        this.money = money;
    }

    void deposit(Money money) {
        performOperationFor(new Deposit(), money);
    }

    void withdrawal(Money money) {
        performOperationFor(new Withdrawal(), money);
    }

    void withdrawalFull() {
        withdrawal(this.money);
    }

    private void performOperationFor(Operation operation, Money money) {
        this.money = operation.operate(this.money, money);
        newHistoric(operation, money);
    }

    private void newHistoric(Operation operation, Money amount) {
        accountOperations.add(new AccountOperation(operation, LocalDateTime.now(), amount, this.money));
    }

    List<AccountOperation> getAccountOperations() {
        return new ArrayList<>(accountOperations);
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
