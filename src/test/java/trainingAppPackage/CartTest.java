package trainingAppPackage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing cart")
class CartTest {

    @DisplayName("Cart with 1000 orders quicker than 10ms")
    @Test
    void simulateLargeCart() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(10), cart::cartSimulator);
    }
}