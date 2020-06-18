package trainingAppPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AccountTest {
    @Test
    void isNotActiveTest(){
        Account account = new Account();
        assertFalse(account.getStatus());
    }

    @Test
    void activateAccount(){
        Account account = new Account();
        assertFalse(account.getStatus());

        account.setActive();
        assertTrue(account.getStatus());
    }

}
