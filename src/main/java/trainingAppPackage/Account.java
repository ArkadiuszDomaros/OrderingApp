package trainingAppPackage;

public class Account {
    private boolean active;

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
