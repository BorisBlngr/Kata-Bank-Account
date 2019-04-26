public class Account {
    private int money;

    Account(int money) {
        this.money = money;
    }

    void deposit(int money) {
        this.money += money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account that = (Account) o;

        return money == that.money;

    }

    @Override
    public int hashCode() {
        return money;
    }
}
