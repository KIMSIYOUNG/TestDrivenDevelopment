
public class Dollar extends Money{

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Money times(int times) {
        return new Dollar(amount * times);
    }


}
