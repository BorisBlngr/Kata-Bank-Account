package fr;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void i_can_deposit_money_on_my_account() {
        Account myAccount = new Account(Money.of(50));

        myAccount.deposit(Money.of(60));

        Account expectedAccount = new Account(Money.of(110));
        assertThat(myAccount).isEqualTo(expectedAccount);
    }

    @Test
    public void i_can_perform_a_partial_withdrawal_of_my_account() {
        Account myAccount = new Account(Money.of(60));

        myAccount.withdrawal(Money.of(20));

        Account expected = new Account(Money.of(40));
        assertThat(myAccount).isEqualTo(expected);
    }

    @Test
    public void i_can_perform_a_full_withdrawal_of_my_account() {
        Account myAccount = new Account(Money.of(45));

        myAccount.withdrawalFull();

        Account accountExpected = new Account(Money.of(0));
        assertThat(myAccount).isEqualTo(accountExpected);
    }

    @Test
    public void an_operation_is_saved_in_my_account_historic() {
        Account myAccount = new Account(Money.of(45));

        myAccount.withdrawal(Money.of(20));
        AccountOperation myOperation = myAccount.getHistoric().get(0);

        AccountOperation operationExpected = new AccountOperation(
                OPERATION.WITHDRAWAL,
                LocalDateTime.now(),
                Money.of(20),
                Money.of(25)
        );
        assertThat(myOperation).isEqualToIgnoringGivenFields(operationExpected, "dateTime");
    }
}