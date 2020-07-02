package trainingAppPackage;

public class Account {
    private boolean active;
    private Adress defaultDeliveryAddress;

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
}
