package orderingAppPackage;

public class Account {
    private boolean active;
    private Adress defaultDeliveryAddress;
    private String email;

    public Account(){
        this.active = false;
    }

    public Account(Adress defaultDeliveryAddress){
        this.active = defaultDeliveryAddress != null;
    }

    public Adress getDeliveryAdress() {
        return defaultDeliveryAddress;
    }

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.defaultDeliveryAddress = deliveryAdress;
    }

    public void setActive(){
        this.active = true;
    }

    public boolean getStatus(){
        return this.active;
    }

    public void setEmail(String email){
        if(email.matches("^[A-Za-z0-9._%+-]+[@]+[A-Za-z]+\\.[A-Za-z]{2,6}$")){
            this.email = email;
        } else {
            throw new IllegalArgumentException(("Wrong email format"));
        }

    }

    public String getEmail() {
        return this.email;
    }
}
