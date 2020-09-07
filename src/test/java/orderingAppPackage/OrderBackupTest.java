package orderingAppPackage;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testing order backup")
class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @DisplayName("Working backup with one order")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(20.00, "Pizza");
        Order order = new Order();

        //when
        order.addToOrder(meal);
        orderBackup.backupOrder(order);

        //then
        System.out.printf("Order %s backed up.%n", order.toString());
    }

    @DisplayName("Backup file created quicker than 15ms with 5 meals")
    @Test
    void backupShouldCreateFileInFiveMS() throws IOException {
        //given
        Meal meal = new Meal(10.00, "Burger");
        Order order = new Order();

        //when
        for(int i = 0; i < 5; i++) {
            order.addToOrder(meal);
        }

        //then
        Assertions.assertTimeout(Duration.ofMillis(15), () -> {
            orderBackup.backupOrder(order);
        });
    }

    @DisplayName("Throw exception if order backup is empty")
    @Test
    void callingBackupWithoutCreatingFileShouldThrowException(){
        //given
        OrderBackup orderBackup = new OrderBackup();
        //when
        //then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}