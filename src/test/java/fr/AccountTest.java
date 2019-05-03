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
        AccountOperation myOperation = myAccount.getAccountOperations().get(0);

        AccountOperation operationExpected = new AccountOperation(
                Operation.WITHDRAWAL,
                LocalDateTime.now(),
                Money.of(20),
                Money.of(25)
        );
        assertThat(myOperation).isEqualToIgnoringGivenFields(operationExpected, "dateTime");
    }

    @Test
    public void my_account_history_can_be_printed() {
        Account myAccount = new Account(Money.of(40));

        myAccount.withdrawal(Money.of(20));
        myAccount.withdrawal(Money.of(10));
        myAccount.deposit(Money.of(100));

        String history = myAccount.printHistory();

        String historyExpected = "-20,00 \n" +
                "-10,00 \n" +
                "+100,00 \n" +
                "- - - - - - - \n" +
                "110,00";

        assertThat(history).isEqualTo(historyExpected);
    }
}