package fr;

import fr.Operation.Operation;

import java.time.LocalDateTime;
import java.util.Objects;

class AccountOperation {

    private final Operation operation;
    private final LocalDateTime dateTime;
    private final Money amount;
    private final Money balance;

    AccountOperation(Operation operation, LocalDateTime dateTime, Money amount, Money balance) {
        this.operation = operation;
        this.dateTime = dateTime;
        this.amount = amount;
        this.balance = balance;
    }

    String print() {
        return operation.symbol() + amount.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountOperation that = (AccountOperation) o;

        if (operation.getClass() != that.operation.getClass()) return false;
        if (!Objects.equals(dateTime, that.dateTime)) return false;
        if (!Objects.equals(amount, that.amount)) return false;
        return Objects.equals(balance, that.balance);

    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountOperation{" +
                "operate=" + operation +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
