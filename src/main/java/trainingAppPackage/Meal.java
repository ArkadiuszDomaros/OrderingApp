package trainingAppPackage;

import java.util.Objects;

public class Meal {

    private double price;
    private String name;

    public Meal(double price){
        this.price = price;
    }

    public Meal(double price, String name){
        this.price = price;
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public double getDiscountPrice( int discount){
        return price * discount/100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Double.compare(meal.price, price) == 0 &&
                Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
