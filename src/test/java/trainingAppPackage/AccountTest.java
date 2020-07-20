package trainingAppPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing accounts")
class AccountTest {

    private Account account;

    @BeforeEach
    void initializeAccount(){
        account = new Account();
    }

    @DisplayName("Account not active after create")
    @Test
    void isNotActive(){
        //then
        assertFalse(account.getStatus());
    }

    @DisplayName("Account activated successfully")
    @Test
    void activateAccount(){
        //when
        account.setActive();

        //then
        assertTrue(account.getStatus());
    }

    @DisplayName("No default address after activate account")
    @Test
    void activatedAccountShouldNotHaveDefaultDeliveryAddress() {
        //when
        Adress adress = account.getDeliveryAdress();

        //then
        assertNull(adress);
    }

    @DisplayName("Default delivery address is not null after set")
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

    @DisplayName("Account activated after create account with default address")
    @Test
    void accountShouldBeActivatedIfCreatedWithDefaultAddress(){
        //given
        Adress adress = new Adress("McDonald", "13");
        Account account = new Account(adress);

        //when
        //then
        assertTrue(account.getStatus());
    }

    @DisplayName("Invalid email should throw exception")
    @Test
    void invalidEmailAddressShouldThrowException(){
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("Wrong email"));
    }

    @DisplayName("Proper email should be set")
    @Test
    void correctEmailShouldSet(){
        //given
        //when
        account.setEmail("correctemail@gmail.com");

        //then
        assertThat(account.getEmail(), is("correctemail@gmail.com"));
    }
}
