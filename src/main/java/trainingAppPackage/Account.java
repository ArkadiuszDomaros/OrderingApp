package trainingAppPackage;

public class Account {
    private boolean active;
    private Adress defaultdeliveryAdress;

    public Adress getDeliveryAdress() {
        return defaultdeliveryAdress;
    }

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.defaultdeliveryAdress = deliveryAdress;
    }

    public Account(){
        this.active = false;
    }

    public void setActive(){
        this.active = true;
    }

    public boolean getStatus(){
        return this.active;
    }
}
