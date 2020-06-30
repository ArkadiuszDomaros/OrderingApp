package trainingAppPackage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

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

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}