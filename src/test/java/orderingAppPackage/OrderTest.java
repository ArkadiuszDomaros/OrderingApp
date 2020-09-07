package orderingAppPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing orders")
class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        order = new Order();
    }

    @AfterEach
    void cleanUp(){
        order.cancel();
    }

    @DisplayName("Order is empty after creating instance")
    @Test
    void orderInstanceShouldBeEmptyAfterCreate(){
        //then
        assertThat(order.getList(), anyOf(empty(),
                hasSize(0)));
    }

    @DisplayName("Size of order is increasing after adding meal")
    @Test
    void addingMealShouldIncreaseListSize(){
        //given
        Meal meal = new Meal(20.00, "Chicken with rice");

        //when
        order.addToOrder(meal);

        //then
        assertThat(order.getList(), anyOf(hasSize(1),
                contains(meal)
        ));
    }

    @DisplayName("Size of order decreasing after removing meal from list")
    @Test
    void removingMealShouldDecreaseListSize(){
        //given
        Meal meal = new Meal(12.00, "Soup");

        //when
        order.addToOrder(meal);
        order.removeFromOrder(meal);

        //then
        assertThat(order.getList(), anyOf(hasSize(0),
                not(contains(meal))
                ));
    }

    @DisplayName("Meals are in proper order")
    @Test
    void mealsShouldBeAtProperOrderAfterAddThem(){
        //given
        Meal meal = new Meal(12.00, "Soup");
        Meal meal2 = new Meal(13.00, "Burger");

        //when
        order.addToOrder(meal);
        order.addToOrder(meal2);

        //then
        assertThat(order.getList(), contains(meal, meal2));
    }

    @DisplayName("100 Meals should be added after 1ms")
    @Test
    void simulateLargeOrder(){
        //given
        Order order = new Order();

        //when
        //then
        assertTimeout(Duration.ofMillis(1), order::orderListSimulator);
    }

    @DisplayName("Total price lower than max int")
    @Test
    void orderTotalPriceShouldBeLowerThanMaxInt(){
        //given
        Meal meal = new Meal(Integer.MAX_VALUE, "Soup");
        Meal meal2 = new Meal(Integer.MAX_VALUE, "Burger");

        //when
        order.addToOrder(meal);
        order.addToOrder(meal2);

        //then
        assertThrows(IllegalStateException.class, () -> order.finalPrice());
    }

    @DisplayName("Price of empty order equal zero")
    @Test
    void emptyOrderPriceShouldBeEqualZero(){
        //then
        assertThat(order.finalPrice(), equalTo(0));
    }

    @DisplayName("Order list should be empty after cancel order")
    @Test
    void orderShouldBeEmptyAfterCancel(){
        //given
        Meal meal = new Meal(Integer.MAX_VALUE, "Soup");
        Meal meal2 = new Meal(Integer.MAX_VALUE, "Burger");

        //when
        order.addToOrder(meal);
        order.addToOrder(meal2);
        order.cancel();

        //then
        assertThat(order.getList().size(), equalTo(0));
    }

}