package fr;

import java.time.LocalDateTime;
import java.util.Objects;

class AccountOperation {

    private OPERATION operation;
    private LocalDateTime datetime;
    private Money amount;
    private Money balance;

    AccountOperation(OPERATION operation, LocalDateTime datetime, Money amount, Money balance) {
        this.operation = operation;
        this.datetime = datetime;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountOperation that = (AccountOperation) o;

        if (operation != that.operation) return false;
        if (!Objects.equals(datetime, that.datetime)) return false;
        if (!Objects.equals(amount, that.amount)) return false;
        return Objects.equals(balance, that.balance);

    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountOperation{" +
                "operation=" + operation +
                ", datetime=" + datetime +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
