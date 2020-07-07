package trainingAppPackage;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> orderList = new ArrayList<>();

    public List<Meal> getList(){
        return orderList;
    }

    public void addToOrder(Meal m){
        orderList.add(m);
    }

    public void removeFromOrder(Meal m){
        orderList.remove(m);
    }

    public void cancel(){
        this.orderList.clear();
    }

    public int finalPrice(){
        int sum = this.orderList.stream().mapToInt(meal -> (int) meal.getPrice()).sum();

        if(sum < 0){
            throw new IllegalStateException("Price higher than limit");
        } else {
            return sum;
        }
    }

    @Override
    public String toString() {
        return "orderList=" + orderList;
    }

    public void orderListSimulator(){
        Meal meal = new Meal(10.00, "Burger");
        for(int i = 0; i<100; i++){
            addToOrder(meal);
        }
    }
}
