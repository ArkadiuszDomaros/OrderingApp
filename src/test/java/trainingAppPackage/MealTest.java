package trainingAppPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldResultDiscountPrice() {
        //given
        Meal meal = new Meal(20);

        //when
        double discountedPrice = meal.getDiscountPrice(50);

        //then
        assertEquals(discountedPrice, 10);
    }

    @Test
    void mealObjectsWithSamePriceAndNameShouldBeEqual() {
        //given
        Meal meal1 = new Meal(20, "Pizza");
        Meal meal2 = new Meal(20, "Pizza");

        //then
        assertEquals(meal1, meal2);
    }
}