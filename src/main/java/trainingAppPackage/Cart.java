package trainingAppPackage;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getCart() {
        return orders;
    }

    public void appendCart(Order order){
        orders.add(order);
    }

    public void clearCart(){
        orders.clear();
    }

    public void cartSimulator(){
        Meal meal = new Meal(10.00, "Burger");
        Order order = new Order();
        order.addToOrder(meal);
        for(int i = 0; i<1000; i++){
            appendCart(order);
        }
        clearCart();
    }
}
