import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountTest {

    @Test
    public void i_can_deposit_money_on_my_account() {
        Account account = new Account(Money.of(50));

        account.deposit(Money.of(60));

        Account expected = new Account(Money.of(110));
        Assertions.assertThat(account).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void money_can_not_be_negative() {
        Money.of(-10);
    }

    @Test
    public void i_can_retrieve_money_on_my_account() {
        Account myAccount = new Account(Money.of(60));

        myAccount.withdrawal(Money.of(20));

        Account expected = new Account(Money.of(40));
        Assertions.assertThat(myAccount).isEqualTo(expected);
    }
}