package trainingAppPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void orderInstanceShouldBeEmptyAfterCreate(){
        //then
        assertThat(order.getList(), empty());
        assertThat(order.getList(), hasSize(0));
    }

    @Test
    void addingMealShouldIncreaseListSize(){
        //given
        Meal meal = new Meal(20.00, "Chicken with rice");

        //when
        order.addToOrder(meal);

        //then
        assertThat(order.getList(), hasSize(1));
        assertThat(order.getList(), hasItem(meal));
    }

    @Test
    void removingMealShouldDecreaseListSize(){
        //given
        Meal meal = new Meal(12.00, "Soup");

        //when
        order.addToOrder(meal);
        order.removeFromOrder(meal);

        //then
        assertThat(order.getList(), hasSize(0));
        assertThat(order.getList(), not(contains(meal)));
    }

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

}