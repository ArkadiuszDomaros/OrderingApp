package trainingAppPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {
    @Test
    void isNotActive(){
        //given
        Account account = new Account();

        //then
        assertFalse(account.getStatus());
    }

    @Test
    void activateAccount(){
        //given
        Account account = new Account();

        //when
        account.setActive();

        //then
        assertTrue(account.getStatus());
    }

    @Test
    void activatedAccountShouldNotHaveDefaultDeliveryAdress() {
        //given
        Account account = new Account();

        //when
        Adress adress = account.getDeliveryAdress();

        //then
        assertNull(adress);
    }

    @Test
    void defaultDeliveryAdressNotNullAfterSet() {
        //given
        Account account = new Account();
        Adress adress = new Adress("Nadmorska", "7e");
        account.setDeliveryAdress(adress);

        //when
        Adress defaultDeliveryAdress = account.getDeliveryAdress();

        //then
        assertNotNull(defaultDeliveryAdress);
    }
}
