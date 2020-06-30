package trainingAppPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {

    private Account account;

    @BeforeEach
    void initializeAccount(){
        account = new Account();
    }

    @Test
    void isNotActive(){
        //then
        assertFalse(account.getStatus());
    }

    @Test
    void activateAccount(){
        //when
        account.setActive();

        //then
        assertTrue(account.getStatus());
    }

    @Test
    void activatedAccountShouldNotHaveDefaultDeliveryAdress() {
        //when
        Adress adress = account.getDeliveryAdress();

        //then
        assertNull(adress);
    }

    @Test
    void defaultDeliveryAdressNotNullAfterSet() {
        //given
        Adress adress = new Adress("Nadmorska", "7e");
        account.setDeliveryAdress(adress);

        //when
        Adress defaultDeliveryAdress = account.getDeliveryAdress();

        //then
        assertNotNull(defaultDeliveryAdress);
    }
}
