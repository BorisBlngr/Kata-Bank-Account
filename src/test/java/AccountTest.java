import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountTest {

    @Test
    public void i_can_deposit_money_on_my_account() {
        Account account = new Account(50);

        account.deposit(60);

        Account expected = new Account(110);
        Assertions.assertThat(account).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void i_can_not_deposit_negative_money_on_my_account() {
        Account account = new Account(50);

        account.deposit(-10);
    }
}