package trainingAppPackage;

import java.util.Objects;

public class Meal {

    private double price;
    private double quantity;
    private String name;

    public Meal(double price){
        this.price = price;
    }

    public Meal(double price, String name){
        this.price = price;
        this.name = name;
    }

    public Meal(double price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getDiscountPrice(int discount){

        double discountedPrice = price * discount/100;
        if(discountedPrice > this.price){
            throw new IllegalArgumentException("Discounted price should be smaller than basic price");
        } else {
            return discountedPrice;
        }

    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
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
