package trainingAppPackage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing meal objects")
class MealTest {

    @DisplayName("Proper result of discounted price")
    @Test
    void shouldResultDiscountPrice() {
        //given
        Meal meal = new Meal(20, "Burger");

        //when
        double discountedPrice = meal.getDiscountPrice(50);

        //then
        assertEquals(discountedPrice, 10);
    }

    @DisplayName("Same meal objects should be equal")
    @Test
    void mealObjectsWithSamePriceAndNameShouldBeEqual() {
        //given
        Meal meal1 = new Meal(20, "Pizza");
        Meal meal2 = new Meal(20, "Pizza");

        //then
        assertEquals(meal1, meal2);
    }

    @DisplayName("Exception when discounted price is bigger than basic price")
    @Test
    void discountedPriceShouldThrowExceptionIfBiggerThanBasicPrice() {
        //given
        Meal meal = new Meal(20.00, "Banana Cake");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountPrice(120));
    }
}