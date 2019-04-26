package fr;

import java.time.LocalDateTime;
import java.util.Objects;

class AccountOperation {

    private final OPERATION operation;
    private final LocalDateTime dateTime;
    private final Money amount;
    private final Money balance;

    AccountOperation(OPERATION operation, LocalDateTime dateTime, Money amount, Money balance) {
        this.operation = operation;
        this.dateTime = dateTime;
        this.amount = amount;
        this.balance = balance;
    }

    String printed() {
        return operation.sign + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountOperation that = (AccountOperation) o;

        if (operation != that.operation) return false;
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
                "operation=" + operation +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
