package orderingAppPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing cart")
class CartTest {

    private Cart cart;

    @BeforeEach
    void initializeCart(){
        cart = new Cart();
    }

    @AfterEach
    void clearCart(){
        cart.clearCart();
    }

    @DisplayName("Cart with 1000 orders quicker than 10ms")
    @Test
    void simulateLargeCart() {
        //when
        //then
        assertTimeout(Duration.ofMillis(10), cart::cartSimulator);
    }

    @DisplayName("Cart should not be empty after add new order")
    @Test
    void cartShouldNotBeEmptyAfterAdd(){
        //given
        Meal meal = new Meal(20.00, "Pizza");
        Order order = new Order();

        //when
        order.addToOrder(meal);
        cart.appendCart(order);

        //then
        assertEquals(cart.getCart().size(), 1);
        assertThat(cart.getCart(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty()))
        ));
    }

    @DisplayName("Cart should be empty after clear")
    @Test
    void cartShouldBeEmptyAfterClear(){
        //given
        Meal meal = new Meal(10.00, "Burger");
        Order order = new Order();

        //when
        order.addToOrder(meal);
        cart.appendCart(order);
        cart.clearCart();

        //then
        assertThat(cart.getCart(), anyOf(
                hasSize(0),
                is(empty())
                ));
    }
}