
public class Dollar extends Money{

    public Dollar(int amount,String currency) {
        super(amount,currency);
    }

    public Money times(int times) {
        return Money.dollar(amount*times);
    }

    @Override
    public String currency() {
        return "USD";
    }


}
